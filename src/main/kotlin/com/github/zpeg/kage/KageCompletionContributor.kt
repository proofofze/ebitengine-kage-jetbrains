package com.github.zpeg.kage

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class KageCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(KageLanguage),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet,
                ) {
                    KageTokens.KEYWORDS.forEach {
                        result.addElement(LookupElementBuilder.create(it).bold().withTypeText("keyword"))
                    }
                    KageTokens.TYPES.forEach {
                        result.addElement(LookupElementBuilder.create(it).withTypeText("type"))
                    }
                    KageTokens.BUILTINS.forEach {
                        result.addElement(LookupElementBuilder.create(it).withTypeText("builtin"))
                    }
                }
            },
        )
    }
}
