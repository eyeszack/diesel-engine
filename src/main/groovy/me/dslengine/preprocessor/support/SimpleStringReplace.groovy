package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class SimpleStringReplace implements Change {
    String find
    String replaceWith
    boolean trimSpace

    String applyTo(String line) {
        if (trimSpace) {
            line = line.trim()
        }

        line.replaceAll find, replaceWith
    }   
}