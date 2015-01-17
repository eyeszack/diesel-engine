package me.dslengine.preprocessor

interface LineProcessor {
    void setLine(String line)
    void setChange(Change change)
    String processLineChanges()
}