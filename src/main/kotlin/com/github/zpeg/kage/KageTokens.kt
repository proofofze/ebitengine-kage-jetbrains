package com.github.zpeg.kage

import com.intellij.psi.tree.TokenSet

object KageTokens {
    // Token types emitted by the lexer.
    @JvmField val KEYWORD = KageTokenType("KEYWORD")
    @JvmField val TYPE = KageTokenType("TYPE")
    @JvmField val BUILTIN = KageTokenType("BUILTIN")
    @JvmField val IDENTIFIER = KageTokenType("IDENTIFIER")
    @JvmField val NUMBER = KageTokenType("NUMBER")
    @JvmField val STRING = KageTokenType("STRING")
    @JvmField val LINE_COMMENT = KageTokenType("LINE_COMMENT")
    @JvmField val BLOCK_COMMENT = KageTokenType("BLOCK_COMMENT")
    @JvmField val OPERATOR = KageTokenType("OPERATOR")
    @JvmField val DOT = KageTokenType("DOT")
    @JvmField val COMMA = KageTokenType("COMMA")
    @JvmField val SEMICOLON = KageTokenType("SEMICOLON")
    @JvmField val LPAREN = KageTokenType("LPAREN")
    @JvmField val RPAREN = KageTokenType("RPAREN")
    @JvmField val LBRACE = KageTokenType("LBRACE")
    @JvmField val RBRACE = KageTokenType("RBRACE")
    @JvmField val LBRACK = KageTokenType("LBRACK")
    @JvmField val RBRACK = KageTokenType("RBRACK")

    @JvmField val COMMENTS: TokenSet = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT)
    @JvmField val STRINGS: TokenSet = TokenSet.create(STRING)

    // Word classes. Ported from sedyh/ebitengine-kage-vscode grammar and
    // extended with Kage keywords/builtins that grammar omits.
    val KEYWORDS = setOf(
        "package", "var", "const", "func", "return",
        "if", "else", "for", "break", "continue",
        "switch", "case", "default", "discard",
        "true", "false", "nil",
    )

    val TYPES = setOf(
        "bool", "int", "float",
        "vec2", "vec3", "vec4",
        "mat2", "mat3", "mat4",
    )

    val BUILTINS = setOf(
        // math
        "sin", "cos", "tan", "asin", "acos", "atan", "atan2",
        "pow", "exp", "log", "exp2", "log2", "sqrt", "inversesqrt",
        "abs", "sign", "floor", "ceil", "fract", "mod", "min", "max",
        "clamp", "mix", "step", "smoothstep",
        "length", "distance", "dot", "cross", "normalize",
        "faceforward", "reflect", "refract", "transpose",
        "dfdx", "dfdy", "fwidth",
        // image / texture
        "imageSrc0At", "imageSrc1At", "imageSrc2At", "imageSrc3At",
        "imageSrc0UnsafeAt", "imageSrc1UnsafeAt", "imageSrc2UnsafeAt", "imageSrc3UnsafeAt",
        "imageSrcTextureSize", "imageDstTextureSize",
        "imageSrcRegionOnTexture", "imageDstRegionOnTexture",
    )
}
