package me.testcase.preprocessor

import groovy.util.GroovyTestCase

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class AddQuotesTest extends GroovyTestCase {

    /*
     * Testing changing:
     * 
     * I need quotes.
     * 
     * To:
     *
     * "I need quotes."
     */
    void testQuoteEntireLine() {
        def change = new AddQuotes(entireLine:true)
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "I need quotes."
        assert lineProcessor.processLineChanges() == "\"I need quotes.\""
    }

    /*
     * Testing changing:
     * 
     * I need quotes.
     * 
     * To:
     *
     * "I" "need" "quotes."
     */
    void testQuoteEachElement() {
        def change = new AddQuotes(eachElement:true)
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "I need quotes."
        assert lineProcessor.processLineChanges() == "\"I\" \"need\" \"quotes.\""
    }

    /*
     * Testing changing:
     * 
     * > GET /resources
     * 
     * To:
     *
     * > GET "/resources"
     */
    void testQuoteAnElement() {
        def change = new AddQuotes(elements:[2])
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "> GET /resources"
        assert lineProcessor.processLineChanges() == "> GET \"/resources\""
    }

    /*
     * Testing changing:
     * 
     * To be or not to be
     * 
     * To:
     *
     * To "be" or "not" to "be"
     */
    void testQuoteSomeElements() {
        def change = new AddQuotes(elements:[1,3,5])
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "To be or not to be"
        assert lineProcessor.processLineChanges() == "To \"be\" or \"not\" to \"be\""
    }
}