package me.testcase.dsl

import groovy.util.GroovyTestCase

import org.codehaus.groovy.control.*

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class PreprocessingAndDSLEngineTest extends GroovyTestCase {

    def testScript = 
"""
This is a test.
So is this.
House
key:value
123:abc
"""

    void testDSL() {
        String newScript = ""
        def mapLineChanges = new ChangeChain(changes:[new AddQuotes(delimiter:":", elements:[1]), new AddString(prepend:"([", append:"])"), new AddString(prepend:"debug ")])
        def stringLineChanges = new ChangeChain(changes:[new AddQuotes(entireLine:true), new AddString(prepend:"debug ")])
        def lineProcessor = new LineProcessor()

        testScript.eachLine { line ->
            lineProcessor.setLine line
            if (line.contains(":")) {
                lineProcessor.setChange mapLineChanges
            } else {
                lineProcessor.setChange stringLineChanges
            }
            newScript += "${lineProcessor.processLineChange()}\n"
        }
        
        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("me.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate newScript
    }
}