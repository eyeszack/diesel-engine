package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class AddString implements Change {
    String append = ""
    String prepend = ""

    String applyTo(String line) {
        prepend+line+append
    }   
}