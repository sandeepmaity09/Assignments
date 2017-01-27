val dir = "."

val filesHere = (new java.io.File(dir)).listFiles

for (file <- filesHere)
  println(file)

def fileLines(file: java.io.File) = 
  scala.io.Source.fromFile(file).getLines().toList


/*
def allFiles = 
  for {
    file <- filesHere
  } yields file
*/


def readFile() = 
  for (
    file <- filesHere;
    line <- fileLines(file)
  ) println(file + ": " + line.toUpperCase)

readFile()
