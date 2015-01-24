package me.dslengine.preprocessor

class LineProcessor {
    String line
    Change change

    String processLineChange() {
        change.process line
    }
}