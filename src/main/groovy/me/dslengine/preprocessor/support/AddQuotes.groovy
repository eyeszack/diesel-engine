package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class AddQuotes implements Change {
    boolean eachElement
    boolean entireLine
    def elements = []

    String process(String line) {
        def newLine = ""
        if (entireLine) {
            newLine = "\"${line}\""
        } else if (eachElement) {
            line.split().each { 
                newLine += "\"${it}\" " 
            }
        } else {
            line.split().eachWithIndex { element, i ->
                if (elements.contains(i)) {
                    newLine += "\"${element}\" "
                } else {
                    newLine += "${element} "
                }
            }
        }
        newLine.trim()
    }
}