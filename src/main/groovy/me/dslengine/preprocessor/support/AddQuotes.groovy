package me.dslengine.preprocessor.support

import me.dslengine.preprocessor.Change

class AddQuotes implements Change {
    String delimiter = " "
    boolean eachElement
    boolean entireLine
    def elements = []

    String process(String line) {
        def newLine = ""
        if (entireLine) {
            newLine = "\"${line}\""
        } else if (eachElement) {
            line.split(delimiter).each { 
                newLine += "\"${it}\" " 
            }
        } else {
            line.split(delimiter).eachWithIndex { element, i ->
                if (elements.contains(i)) {
                    newLine += "\"${element}\"${delimiter}"
                } else {
                    newLine += "${element}${delimiter}"
                }
            }
        }
        newLine.trim()
    }
}