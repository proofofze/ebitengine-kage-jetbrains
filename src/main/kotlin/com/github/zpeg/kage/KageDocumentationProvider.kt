package com.github.zpeg.kage

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement

class KageDocumentationProvider : AbstractDocumentationProvider() {
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? =
        lookup(element, originalElement)

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? =
        lookup(element, originalElement)

    private fun lookup(element: PsiElement?, originalElement: PsiElement?): String? {
        val key = originalElement?.text?.takeIf { it.isNotBlank() } ?: element?.text ?: return null
        return KageDocs.MAP[key]
    }
}
