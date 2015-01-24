package me.dslengine.preprocessor

class FileProcessor {
    File file
    Change change

    String processFileChange() {
        String newFileContents = ""

        file.eachLine { line ->
            newFileContents += change.process line
            newFileContents += "\n"
        }
        newFileContents
    }
}