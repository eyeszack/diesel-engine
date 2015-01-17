package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class SimpleStringReplaceChange implements Change {
    String find
    String replace

    String process(String line) {
        line.replace find, replace
    }   
}