# Kage for JetBrains

[![Build](https://github.com/proofofze/ebitengine-kage-jetbrains/actions/workflows/build.yml/badge.svg)](https://github.com/proofofze/ebitengine-kage-jetbrains/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

IDE support for [Kage](https://ebitengine.org/en/documents/shader.html), the
[Ebitengine](https://ebitengine.org) shading language, in IntelliJ-platform IDEs
(IntelliJ IDEA, GoLand, CLion, …).

Native (lexer-based) port of the VS Code extension
[sedyh/ebitengine-kage-vscode](https://github.com/sedyh/ebitengine-kage-vscode).

## Features

- **Syntax highlighting** for `.kage` — keywords, types, builtins, numbers, comments
- **Code completion** for keywords, types, and builtin functions
- **Quick documentation** on hover for builtins and types
- **Brace matching** and **comment toggling** (`//`, `/* */`)
- **Live templates** (snippets): `fragment`, `vec2/3/4`, `mat2/3/4`, `imageSrcNAt`,
  `imageSrcTextureSize`, `clamp`, `mix`, `smoothstep`, `discard`, …
- **Configurable colors** under *Settings → Editor → Color Scheme → Kage*

## Install

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

## Architecture

Lexer-based ("Option C") — full IDE features without a hand-maintained grammar.

| Concern            | Class / file                                       |
|--------------------|----------------------------------------------------|
| Language / filetype| `KageLanguage`, `KageFileType`, `KageFile`         |
| Lexing             | `KageLexer` (hand-written, no codegen)             |
| Flat PSI           | `KageParserDefinition` (unlocks completion + hover)|
| Highlighting       | `KageSyntaxHighlighter`, `KageSyntaxHighlighterFactory` |
| Completion         | `KageCompletionContributor`                        |
| Hover docs         | `KageDocumentationProvider`, `KageDocs`            |
| Braces / comments  | `KageBraceMatcher`, `KageCommenter`                |
| Snippets           | `resources/liveTemplates/Kage.xml`, `KageTemplateContextType` |
| Color settings     | `KageColorSettingsPage`                            |
| Token definitions  | `KageTokens` (keywords / types / builtins)         |

Want go-to-definition, find-usages, and rename? See
[CONTRIBUTING.md](CONTRIBUTING.md) → "Going further (real grammar)".

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
