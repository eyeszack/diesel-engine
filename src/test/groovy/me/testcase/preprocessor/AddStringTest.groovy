package me.testcase.preprocessor

import groovy.util.GroovyTestCase

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class AddStringTest extends GroovyTestCase {

    void testPrependSting() {
        def change = new AddString(prepend:"START ")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLineChange() == "START I am a cat lover!"
    }

    void testAppendString() {
        def change = new AddString(append:" END")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLineChange() == "I am a cat lover! END"
    }

    void testBothAppendingAndPrepending() {
        def change = new AddString(prepend:"START ", append:" END")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLineChange() == "START I am a cat lover! END"
    }
}