package com.github.zpeg.kage

import com.intellij.psi.tree.IElementType

class KageTokenType(debugName: String) : IElementType(debugName, KageLanguage) {
    override fun toString(): String = "KageTokenType.${super.toString()}"
}
