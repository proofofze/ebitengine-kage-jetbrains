package com.github.zpeg.kage

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class KageFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, KageLanguage) {
    override fun getFileType(): FileType = KageFileType.INSTANCE
    override fun toString(): String = "Kage File"
}
