package me.testcase.preprocessor

import groovy.util.GroovyTestCase

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class SimpleStringReplaceTest extends GroovyTestCase {

    void testPlainReplace() {
        def change = new SimpleStringReplace(find:"TEST", replaceWith:"works")
        def lineProcessor = new LineProcessor(change:change)
        def lines = ["I hope this TEST!","I hope this TEST!","I hope this TEST!","I hope this works!"]

        lines.each { line ->
            lineProcessor.line = line
            assert lineProcessor.processLineChange() == "I hope this works!"
        }
    }

    void testRegexReplace() {
        def change = new SimpleStringReplace(find:"^>", replaceWith:"REQUEST")
        def lineProcessor = new LineProcessor(line:"> GET /resources", change:change)
        assert lineProcessor.processLineChange() == "REQUEST GET /resources"
    }

    void testRegexReplaceNoChange() {
        def change = new SimpleStringReplace(find:"^>", replaceWith:"REQUEST")
        def lineProcessor = new LineProcessor(line:"REQUEST GET /resources", change:change)
        assert lineProcessor.processLineChange() == "REQUEST GET /resources"
    }

    void testTrimSpaceRegexReplace() {
        def change = new SimpleStringReplace(find:"^>", replaceWith:"REQUEST", trimSpace:true)
        def lineProcessor = new LineProcessor(line:"    > GET /resources   ", change:change)
        assert lineProcessor.processLineChange() == "REQUEST GET /resources"
    }
}