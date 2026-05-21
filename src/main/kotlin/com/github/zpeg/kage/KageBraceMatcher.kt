package com.github.zpeg.kage

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class KageBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(KageTokens.LBRACE, KageTokens.RBRACE, true),
            BracePair(KageTokens.LPAREN, KageTokens.RPAREN, false),
            BracePair(KageTokens.LBRACK, KageTokens.RBRACK, false),
        )
    }
}
