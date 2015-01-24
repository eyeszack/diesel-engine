package me.testcase.dsl

import groovy.util.GroovyTestCase

import org.codehaus.groovy.control.*

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

class FilePreprocessingAndDSLEngineTest extends GroovyTestCase {

    void testDSL() {
        def stringLineChanges = new ChangeChain(changes:[new AddQuotes(entireLine:true), new AddString(prepend:"debug ")])
        def fileProcessor = new FileProcessor(file:new File("src/test/resources/test.dsl"), change:stringLineChanges)
        String newScript = fileProcessor.processFile()
        
        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("me.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate newScript
    }
}