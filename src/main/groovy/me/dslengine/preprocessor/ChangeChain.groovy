package me.dslengine.preprocessor

class ChangeChain implements Change {

    Change[] changes = []

    String process(String line) {
        String modifiedLine = line
        changes.each { change ->
            modifiedLine = change.process modifiedLine
        }
        modifiedLine
    }

}