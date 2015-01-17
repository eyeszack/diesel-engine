#!/usr/bin/env groovy
import groovy.io.FileType

import me.dslengine.preprocessor.*
import me.dslengine.preprocessor.support.*

try {
    if (args) {
        def change = new SimpleStringReplaceChange(find:"TEST", replace:"works")
        def lineProcessor = new LineProcessor(change:change)

        def file = new File(args[0])

        file.eachLine { line ->
            lineProcessor.line = line
            assert lineProcessor.processLineChanges() == "I hope this works!"
        }
    } else {
        println "Usage: groovy -cp lib/dslengine-X.X.X.jar SimpleStringReplaceChangeTest.groovy replace.dsl"
    }
} catch (Exception e) {
    println e
}