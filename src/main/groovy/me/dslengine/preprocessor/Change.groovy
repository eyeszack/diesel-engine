package me.dslengine.preprocessor

interface Change {
    String process(String line)
}