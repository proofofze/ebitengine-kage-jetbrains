package com.github.zpeg.kage

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class KageColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = KageIcons.FILE
    override fun getHighlighter(): SyntaxHighlighter = KageSyntaxHighlighter()
    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName(): String = "Kage"

    override fun getDemoText(): String = """
        package main

        // Fragment is the shader entrypoint.
        func Fragment(dstPos vec4, srcPos vec2, color vec4) vec4 {
            var c vec4 = imageSrc0At(srcPos)
            t := clamp(c.r, 0.0, 1.0)
            return vec4(c.rgb * t, 1.0)
        }
    """.trimIndent()

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", KageSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Type", KageSyntaxHighlighter.TYPE),
            AttributesDescriptor("Builtin function", KageSyntaxHighlighter.BUILTIN),
            AttributesDescriptor("Number", KageSyntaxHighlighter.NUMBER),
            AttributesDescriptor("String", KageSyntaxHighlighter.STRING),
            AttributesDescriptor("Line comment", KageSyntaxHighlighter.LINE_COMMENT),
            AttributesDescriptor("Block comment", KageSyntaxHighlighter.BLOCK_COMMENT),
            AttributesDescriptor("Operator", KageSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Parentheses", KageSyntaxHighlighter.PAREN),
            AttributesDescriptor("Braces", KageSyntaxHighlighter.BRACE),
            AttributesDescriptor("Brackets", KageSyntaxHighlighter.BRACKET),
        )
    }
}
