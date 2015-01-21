package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class AddString implements Change {
    String append = ""
    String prepend = ""

    String process(String line) {
        prepend+line+append
    }   
}