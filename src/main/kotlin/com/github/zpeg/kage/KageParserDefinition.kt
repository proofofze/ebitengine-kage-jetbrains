package com.github.zpeg.kage

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

/**
 * Flat parser: wraps every lexer token under a single file root. No grammar,
 * but it yields a real PSI tree of leaf tokens, which is enough for completion
 * and quick-documentation to read the identifier under the caret.
 */
class KageParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = KageLexer()

    override fun createParser(project: Project?): PsiParser = PsiParser { root, builder ->
        val mark = builder.mark()
        while (!builder.eof()) builder.advanceLexer()
        mark.done(root)
        builder.treeBuilt
    }

    override fun getFileNodeType(): IFileElementType = FILE
    override fun getCommentTokens(): TokenSet = KageTokens.COMMENTS
    override fun getStringLiteralElements(): TokenSet = KageTokens.STRINGS

    override fun createElement(node: ASTNode): PsiElement = ASTWrapperPsiElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = KageFile(viewProvider)

    companion object {
        val FILE: IFileElementType = IFileElementType(KageLanguage)
    }
}
