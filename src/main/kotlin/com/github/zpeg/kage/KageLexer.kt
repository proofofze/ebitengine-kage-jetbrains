package com.github.zpeg.kage

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

/**
 * Hand-written lexer for Kage. Deterministic, no codegen step, so the project
 * builds without a JFlex/Grammar-Kit toolchain. To move to the idiomatic JFlex
 * route later, add the org.jetbrains.grammarkit plugin, write a `.flex`, wire a
 * `generateLexer` task, and replace this class with a FlexAdapter wrapper.
 */
class KageLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var bufferEnd = 0
    private var tokenStart = 0
    private var tokenEnd = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.bufferEnd = endOffset
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.tokenType = null
        advance()
    }

    override fun getState(): Int = 0
    override fun getTokenType(): IElementType? = tokenType
    override fun getTokenStart(): Int = tokenStart
    override fun getTokenEnd(): Int = tokenEnd
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = bufferEnd

    override fun advance() {
        tokenStart = tokenEnd
        if (tokenStart >= bufferEnd) {
            tokenType = null
            return
        }
        val c = buffer[tokenStart]
        when {
            c.isWhitespace() -> {
                var i = tokenStart + 1
                while (i < bufferEnd && buffer[i].isWhitespace()) i++
                tokenEnd = i
                tokenType = TokenType.WHITE_SPACE
            }

            c == '/' && peek(1) == '/' -> {
                var i = tokenStart + 2
                while (i < bufferEnd && buffer[i] != '\n') i++
                tokenEnd = i
                tokenType = KageTokens.LINE_COMMENT
            }

            c == '/' && peek(1) == '*' -> {
                var i = tokenStart + 2
                while (i + 1 < bufferEnd && !(buffer[i] == '*' && buffer[i + 1] == '/')) i++
                tokenEnd = if (i + 1 < bufferEnd) i + 2 else bufferEnd
                tokenType = KageTokens.BLOCK_COMMENT
            }

            c == '"' -> {
                var i = tokenStart + 1
                while (i < bufferEnd && buffer[i] != '"' && buffer[i] != '\n') {
                    if (buffer[i] == '\\' && i + 1 < bufferEnd) i++
                    i++
                }
                if (i < bufferEnd && buffer[i] == '"') i++
                tokenEnd = i
                tokenType = KageTokens.STRING
            }

            c.isDigit() || (c == '.' && peek(1)?.isDigit() == true) -> {
                var i = tokenStart + 1
                while (i < bufferEnd && (buffer[i].isLetterOrDigit() || buffer[i] == '.' || buffer[i] == '_')) i++
                tokenEnd = i
                tokenType = KageTokens.NUMBER
            }

            c.isLetter() || c == '_' -> {
                var i = tokenStart + 1
                while (i < bufferEnd && (buffer[i].isLetterOrDigit() || buffer[i] == '_')) i++
                tokenEnd = i
                tokenType = classify(buffer.subSequence(tokenStart, i).toString())
            }

            else -> {
                tokenEnd = tokenStart + 1
                tokenType = punctuation(c)
            }
        }
    }

    private fun peek(offset: Int): Char? {
        val i = tokenStart + offset
        return if (i < bufferEnd) buffer[i] else null
    }

    private fun classify(word: String): IElementType = when (word) {
        in KageTokens.KEYWORDS -> KageTokens.KEYWORD
        in KageTokens.TYPES -> KageTokens.TYPE
        in KageTokens.BUILTINS -> KageTokens.BUILTIN
        else -> KageTokens.IDENTIFIER
    }

    private fun punctuation(c: Char): IElementType = when (c) {
        '{' -> KageTokens.LBRACE
        '}' -> KageTokens.RBRACE
        '(' -> KageTokens.LPAREN
        ')' -> KageTokens.RPAREN
        '[' -> KageTokens.LBRACK
        ']' -> KageTokens.RBRACK
        ',' -> KageTokens.COMMA
        ';' -> KageTokens.SEMICOLON
        '.' -> KageTokens.DOT
        '+', '-', '*', '/', '%', '=', '<', '>', '!', '&', '|', '^', ':' -> KageTokens.OPERATOR
        else -> TokenType.BAD_CHARACTER
    }
}
