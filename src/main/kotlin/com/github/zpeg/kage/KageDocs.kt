package com.github.zpeg.kage

/** Brief reference shown on hover / quick documentation, keyed by identifier. */
object KageDocs {
    val MAP: Map<String, String> = mapOf(
        // types
        "vec2" to "<b>vec2</b> — 2-component float vector.",
        "vec3" to "<b>vec3</b> — 3-component float vector.",
        "vec4" to "<b>vec4</b> — 4-component float vector (also used for RGBA color).",
        "mat2" to "<b>mat2</b> — 2x2 float matrix.",
        "mat3" to "<b>mat3</b> — 3x3 float matrix.",
        "mat4" to "<b>mat4</b> — 4x4 float matrix.",

        // trig
        "sin" to "<b>sin(x)</b> — sine of x (radians).",
        "cos" to "<b>cos(x)</b> — cosine of x (radians).",
        "tan" to "<b>tan(x)</b> — tangent of x (radians).",
        "asin" to "<b>asin(x)</b> — arcsine, result in radians.",
        "acos" to "<b>acos(x)</b> — arccosine, result in radians.",
        "atan" to "<b>atan(y_over_x)</b> — arctangent, result in radians.",
        "atan2" to "<b>atan2(y, x)</b> — angle of the vector (x, y) in radians.",

        // exponential
        "pow" to "<b>pow(x, y)</b> — x raised to the power y.",
        "exp" to "<b>exp(x)</b> — e^x.",
        "log" to "<b>log(x)</b> — natural logarithm.",
        "exp2" to "<b>exp2(x)</b> — 2^x.",
        "log2" to "<b>log2(x)</b> — base-2 logarithm.",
        "sqrt" to "<b>sqrt(x)</b> — square root.",
        "inversesqrt" to "<b>inversesqrt(x)</b> — 1 / sqrt(x).",

        // common
        "abs" to "<b>abs(x)</b> — absolute value.",
        "sign" to "<b>sign(x)</b> — -1, 0, or 1 by sign of x.",
        "floor" to "<b>floor(x)</b> — largest integer &le; x.",
        "ceil" to "<b>ceil(x)</b> — smallest integer &ge; x.",
        "fract" to "<b>fract(x)</b> — fractional part, x - floor(x).",
        "mod" to "<b>mod(x, y)</b> — x modulo y.",
        "min" to "<b>min(x, y)</b> — smaller of x and y.",
        "max" to "<b>max(x, y)</b> — larger of x and y.",
        "clamp" to "<b>clamp(x, minVal, maxVal)</b> — constrain x to [minVal, maxVal].",
        "mix" to "<b>mix(x, y, a)</b> — linear blend, x*(1-a) + y*a.",
        "step" to "<b>step(edge, x)</b> — 0 if x &lt; edge, else 1.",
        "smoothstep" to "<b>smoothstep(edge0, edge1, x)</b> — smooth Hermite interpolation between 0 and 1.",

        // geometric
        "length" to "<b>length(v)</b> — Euclidean length of v.",
        "distance" to "<b>distance(p0, p1)</b> — distance between p0 and p1.",
        "dot" to "<b>dot(a, b)</b> — dot product.",
        "cross" to "<b>cross(a, b)</b> — cross product of two vec3.",
        "normalize" to "<b>normalize(v)</b> — v scaled to unit length.",
        "faceforward" to "<b>faceforward(N, I, Nref)</b> — orient N to face away from I.",
        "reflect" to "<b>reflect(I, N)</b> — reflection of I about normal N.",
        "refract" to "<b>refract(I, N, eta)</b> — refraction of I through normal N.",
        "transpose" to "<b>transpose(m)</b> — transposed matrix.",

        // derivatives
        "dfdx" to "<b>dfdx(p)</b> — partial derivative of p with respect to screen x.",
        "dfdy" to "<b>dfdy(p)</b> — partial derivative of p with respect to screen y.",
        "fwidth" to "<b>fwidth(p)</b> — abs(dfdx(p)) + abs(dfdy(p)).",

        // image / texture
        "imageSrc0At" to "<b>imageSrc0At(texelCoords vec2) vec4</b> — sample source image 0 at the given texel coordinates.",
        "imageSrc1At" to "<b>imageSrc1At(texelCoords vec2) vec4</b> — sample source image 1.",
        "imageSrc2At" to "<b>imageSrc2At(texelCoords vec2) vec4</b> — sample source image 2.",
        "imageSrc3At" to "<b>imageSrc3At(texelCoords vec2) vec4</b> — sample source image 3.",
        "imageSrcTextureSize" to "<b>imageSrcTextureSize() vec2</b> — size of the source texture in pixels.",
        "imageDstTextureSize" to "<b>imageDstTextureSize() vec2</b> — size of the destination texture in pixels.",
        "imageSrcRegionOnTexture" to "<b>imageSrcRegionOnTexture() (vec2, vec2)</b> — origin and size of the source region on its texture.",
        "imageDstRegionOnTexture" to "<b>imageDstRegionOnTexture() (vec2, vec2)</b> — origin and size of the destination region on its texture.",

        // keywords of note
        "discard" to "<b>discard()</b> — discard the current fragment; nothing is drawn.",
        "Fragment" to "<b>func Fragment(dstPos vec4, srcPos vec2, color vec4) vec4</b> — Kage fragment shader entrypoint; returns the output color.",
    )
}
