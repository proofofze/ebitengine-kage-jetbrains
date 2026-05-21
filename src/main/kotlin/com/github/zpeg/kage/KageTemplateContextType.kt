package com.github.zpeg.kage

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class KageTemplateContextType : TemplateContextType("Kage") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean =
        templateActionContext.file is KageFile
}
