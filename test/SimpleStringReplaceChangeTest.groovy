import groovy.util.GroovyTestCase

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class SimpleStringReplaceChangeTest extends GroovyTestCase {
    void testReplace() {
        def change = new SimpleStringReplaceChange(find:"TEST", replaceWith:"works")
        def lineProcessor = new LineProcessor(change:change)
        def file = new File("replace.dsl")

        file.eachLine { line ->
            lineProcessor.line = line
            assert lineProcessor.line == "I hope this TEST!"
            assert lineProcessor.processLineChanges() == "I hope this works!"
        }
    }
}