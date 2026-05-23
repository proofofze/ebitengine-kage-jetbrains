# Kage for JetBrains

[![Build](https://github.com/proofofze/ebitengine-kage-jetbrains/actions/workflows/build.yml/badge.svg)](https://github.com/proofofze/ebitengine-kage-jetbrains/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

IDE support for [Kage](https://ebitengine.org/en/documents/shader.html), the
[Ebitengine](https://ebitengine.org) shading language, in IntelliJ-platform IDEs
(IntelliJ IDEA, GoLand, CLion, …).

Native (lexer-based) port of the VS Code extension
[sedyh/ebitengine-kage-vscode](https://github.com/sedyh/ebitengine-kage-vscode).

## Features

- **`.kage` file type** — dedicated file icon and editor association.
- **Syntax highlighting** for:
  - Keywords — `package`, `var`, `const`, `func`, `return`, `if`, `else`, `for`,
    `break`, `continue`, `switch`, `case`, `default`, `discard`, `true`, `false`, `nil`
  - Types — `bool`, `int`, `float`, `vec2`/`vec3`/`vec4`, `mat2`/`mat3`/`mat4`
  - Builtin functions — math (`sin`, `cos`, `clamp`, `mix`, `smoothstep`,
    `length`, `dot`, `normalize`, `dfdx`, …) and image/texture
    (`imageSrc0At`…`imageSrc3At`, `imageSrcTextureSize`, `imageSrcRegionOnTexture`, …)
  - Numbers, line (`//`) and block (`/* */`) comments, operators, and brackets
- **Code completion** for keywords, types, and builtin functions.
- **Quick documentation on hover** for builtins and types (signature + summary).
- **Brace matching** for `{}`, `()`, and `[]`.
- **Comment toggling** — line (`//`) and block (`/* */`).
- **Live templates (snippets):**
  - `fragment` — full `Fragment` shader entrypoint
  - `vec2` / `vec3` / `vec4`, `mat2` / `mat3` / `mat4` — constructors
  - `imageSrcNAt`, `imageSrcTextureSize`, `imageSrcRegionOnTexture` — image helpers
  - `clamp`, `mix`, `smoothstep`, `discard` — common operations
- **Configurable colors** — adjust every token type under
  *Settings → Editor → Color Scheme → Kage*.

## Install

[![Install](https://img.shields.io/badge/JetBrains-Install_from_Marketplace-000?logo=jetbrains)](https://plugins.jetbrains.com/plugin/31923-kage)

### From a release zip (sideload)

1. Download `kage-jetbrains-<version>.zip` (from Releases, or `./gradlew buildPlugin`
   → `build/distributions/`).
2. In your IDE: *Settings → Plugins → ⚙ → Install Plugin from Disk…* → pick the zip.
3. Restart when prompted.

## Build from source

Requires a JDK 17+ to run Gradle (the JDK 21 toolchain is auto-provisioned).

```bash
git clone git@github.com:proofofze/ebitengine-kage-jetbrains.git
cd ebitengine-kage-jetbrains
./gradlew buildPlugin     # -> build/distributions/*.zip
./gradlew runIde          # launch a sandbox IDE with the plugin loaded
```

Open `samples/example.kage` in the sandbox IDE to try highlighting, completion,
hover, and the `fragment` live template.

### Targeting another IDE

Edit the `intellijPlatform { intellijIdeaCommunity("…") }` line in
`build.gradle.kts`. Swap for `goland(…)`, `clion(…)`, etc. The language support
is IDE-agnostic.

## Contributing

Issues and PRs welcome — see [CONTRIBUTING.md](CONTRIBUTING.md).

## Credits

- [sedyh/ebitengine-kage-vscode](https://github.com/sedyh/ebitengine-kage-vscode)
  — original VS Code extension and grammar (CC0-1.0); this project ports its
  token sets and snippets.
- [Ebitengine](https://ebitengine.org) by Hajime Hoshi — the engine and Kage.

## License

[MIT](LICENSE) © proofofze

## Disclaimer

> ⚠️ This repository was built quickly, with low-to-minimal attention to
> security. It is provided **as is**, with no warranty (see [LICENSE](LICENSE)).
> **Use at your own risk** and **review the code yourself** before building,
> installing, or running it.
