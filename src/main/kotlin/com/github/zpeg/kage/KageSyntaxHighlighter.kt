package com.github.zpeg.kage

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class KageSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = KageLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        KageTokens.KEYWORD -> KEYWORD_KEYS
        KageTokens.TYPE -> TYPE_KEYS
        KageTokens.BUILTIN -> BUILTIN_KEYS
        KageTokens.NUMBER -> NUMBER_KEYS
        KageTokens.STRING -> STRING_KEYS
        KageTokens.LINE_COMMENT -> LINE_COMMENT_KEYS
        KageTokens.BLOCK_COMMENT -> BLOCK_COMMENT_KEYS
        KageTokens.OPERATOR -> OPERATOR_KEYS
        KageTokens.DOT, KageTokens.COMMA, KageTokens.SEMICOLON -> SEMICOLON_KEYS
        KageTokens.LPAREN, KageTokens.RPAREN -> PAREN_KEYS
        KageTokens.LBRACE, KageTokens.RBRACE -> BRACE_KEYS
        KageTokens.LBRACK, KageTokens.RBRACK -> BRACKET_KEYS
        else -> EMPTY
    }

    companion object {
        val KEYWORD = createTextAttributesKey("KAGE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val TYPE = createTextAttributesKey("KAGE_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME)
        val BUILTIN = createTextAttributesKey("KAGE_BUILTIN", DefaultLanguageHighlighterColors.STATIC_METHOD)
        val NUMBER = createTextAttributesKey("KAGE_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val STRING = createTextAttributesKey("KAGE_STRING", DefaultLanguageHighlighterColors.STRING)
        val LINE_COMMENT = createTextAttributesKey("KAGE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BLOCK_COMMENT = createTextAttributesKey("KAGE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        val OPERATOR = createTextAttributesKey("KAGE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val SEMICOLON = createTextAttributesKey("KAGE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
        val PAREN = createTextAttributesKey("KAGE_PAREN", DefaultLanguageHighlighterColors.PARENTHESES)
        val BRACE = createTextAttributesKey("KAGE_BRACE", DefaultLanguageHighlighterColors.BRACES)
        val BRACKET = createTextAttributesKey("KAGE_BRACKET", DefaultLanguageHighlighterColors.BRACKETS)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val TYPE_KEYS = arrayOf(TYPE)
        private val BUILTIN_KEYS = arrayOf(BUILTIN)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val STRING_KEYS = arrayOf(STRING)
        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val BLOCK_COMMENT_KEYS = arrayOf(BLOCK_COMMENT)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
        private val PAREN_KEYS = arrayOf(PAREN)
        private val BRACE_KEYS = arrayOf(BRACE)
        private val BRACKET_KEYS = arrayOf(BRACKET)
        private val EMPTY = emptyArray<TextAttributesKey>()
    }
}
