package me.dslengine.preprocessor

interface Change {
    String applyTo(String line)
}