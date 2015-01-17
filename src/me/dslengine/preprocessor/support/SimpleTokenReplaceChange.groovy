package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class SimpleTokenReplaceChange implements Change {
    Token find
    Token replace

    String process(String line) {
        // do nothing right now
        line
    }   
}