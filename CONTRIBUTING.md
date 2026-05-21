# Contributing

Thanks for your interest in improving Kage for JetBrains.

## Prerequisites

- A JDK **17 or newer** on `PATH` to run Gradle. The JDK 21 toolchain used to
  compile the plugin is auto-provisioned by the Foojay resolver.

## Develop

```bash
./gradlew runIde          # sandbox IDE with the plugin loaded
./gradlew buildPlugin      # produce build/distributions/*.zip
./gradlew test             # run tests
./gradlew verifyPlugin     # IntelliJ Plugin Verifier (downloads target IDEs)
```

Open `samples/example.kage` in the sandbox to exercise highlighting, completion,
hover, and live templates.

## Project layout

- `KageTokens.kt` — the source of truth for keywords, types, and builtins.
  Add new language tokens here; the lexer, highlighter, and completion all read
  from it.
- `KageDocs.kt` — hover text, keyed by identifier.
- `resources/liveTemplates/Kage.xml` — snippets. Each template needs the
  `<context><option name="KAGE" value="true"/></context>` block.
- `resources/META-INF/plugin.xml` — extension registrations.

## Code style

- Kotlin official style; keep classes small and single-purpose.
- Match the existing file structure (one extension point per class).
- Update `CHANGELOG.md` under `## [Unreleased]` with user-facing changes.

## Going further (real grammar)

The lexer is hand-written so the project builds with no codegen. For
go-to-definition, find-usages, rename, and a structure view, migrate to a real
grammar:

1. Add `id("org.jetbrains.grammarkit")` to `plugins {}`.
2. Write `KageLexer.flex` (JFlex) and `Kage.bnf` (Grammar-Kit).
3. Wire `generateLexer` / `generateParser` tasks and add their output to the
   source sets.
4. Replace `KageLexer` with a `FlexAdapter` wrapper, and the flat parser in
   `KageParserDefinition` with the generated parser and PSI element types.

## Releasing / publishing

Signing and publishing read secrets **from the environment only** — never commit
them. Generate a signing certificate per the
[JetBrains plugin signing guide](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html)
and a Marketplace token at <https://plugins.jetbrains.com/author/me/tokens>.

```bash
export CERTIFICATE_CHAIN="$(cat chain.crt)"
export PRIVATE_KEY="$(cat private.pem)"
export PRIVATE_KEY_PASSWORD="…"
export PUBLISH_TOKEN="…"

./gradlew signPlugin       # sign the distribution
./gradlew publishPlugin    # sign + upload to JetBrains Marketplace
```

The first version of a new plugin must be uploaded via the Marketplace web form
and pass moderation; `publishPlugin` automates subsequent updates.

## Pull requests

- Keep PRs focused; one feature or fix per PR.
- Ensure `./gradlew buildPlugin test` passes before opening.
- Describe the change and link any related issue.
