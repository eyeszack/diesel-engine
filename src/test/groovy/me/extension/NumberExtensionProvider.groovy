package me.extension

import me.dslengine.extension.*

class NumberExtensionProvider implements LanguageExtensionProvider {
    void extend(script) {
        Number.metaClass.key = { String key ->
            println "${key}:${delegate}"
        }       
    }
}