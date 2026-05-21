package com.github.zpeg.kage

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class KageFileType private constructor() : LanguageFileType(KageLanguage) {
    override fun getName(): String = "Kage"
    override fun getDescription(): String = "Ebitengine Kage shader"
    override fun getDefaultExtension(): String = "kage"
    override fun getIcon(): Icon = KageIcons.FILE

    companion object {
        @JvmField
        val INSTANCE = KageFileType()
    }
}
