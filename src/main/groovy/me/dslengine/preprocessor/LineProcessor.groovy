package me.dslengine.preprocessor

class LineProcessor {
    String line
    Change change

    String processLineChanges() {
        change.process line
    }
}