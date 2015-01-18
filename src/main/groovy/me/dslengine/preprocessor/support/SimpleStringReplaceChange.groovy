package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class SimpleStringReplaceChange implements Change {
    String find
    String replaceWith
    boolean trimSpace

    String process(String line) {
        if (trimSpace) {
        	line = line.trim()
        }

        line.replaceAll find, replaceWith
    }   
}