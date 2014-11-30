package me.dslengine

import me.dslengine.extension.*
import me.dslengine.keyword.*

abstract class DSLEngineScript extends Script {

    def DSLEngineScript() {
        //Enable inheritance
        ExpandoMetaClass.enableGlobally()
        
        /* Add language extensions. */
        ServiceLoader<LanguageExtensionProvider> languageExtensionProviderLoader = ServiceLoader.load(LanguageExtensionProvider.class)
        Iterator<LanguageExtensionProvider> languageExtensionProviders = languageExtensionProviderLoader.iterator()
        for (LanguageExtensionProvider extension : languageExtensionProviders) {
            extension.extend this
        }

        /* Load up the dsl keywords. */
        ServiceLoader<KeywordProvider> keywordProviderLoader = ServiceLoader.load(KeywordProvider.class)
        Iterator<KeywordProvider> keywordProviders = keywordProviderLoader.iterator()
        for (KeywordProvider keywords : keywordProviders) {
            addKeywords(keywords)   
        }
    }

    private void addKeywords(keywords) {
        keywords.getKeywords()?.each { keyword ->
            this.metaClass."$keyword.name" = keyword.closure
            keyword.aliases?.each { alias ->
                this.metaClass."$alias" = keyword.closure
            }
        }
    }
}