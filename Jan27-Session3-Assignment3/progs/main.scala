import java.io._

object Demo {

  
  val dir = "."
  
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines()

  def readFile() = {
    val filesHere = (new java.io.File(dir)).listFiles
    for ( file <- filesHere if file.getName.endsWith(".txt"); line <- fileLines(file)) {
      println(line)
    }
  }


  def writeFile() = {
    val filesHere = (new java.io.File(dir)).listFiles
    for ( file <- filesHere if file.getName.endsWith(".txt")) {
        val writer = new PrintWriter(new File("../output/"+file));
        for( line <- fileLines(file)) {
          val temp = line.toUpperCase
          writer.write(temp+"\n")
        }
      writer.close()
    }
  }

  def wordCount() = {
    val filesHere = (new java.io.File(dir)).listFiles
   
    for(file <- filesHere if file.getName.endsWith(".txt")) {
      val writer = new PrintWriter(new File("../count/"+file));
      val lines = fileLines(file);
      val line = lines.mkString
      val splitLine = line.split("\\s").groupBy(x=>x).map(x=>(x._1,x._2.size))
      val words = splitLine.keys
      for(i<-words){
        val line = i+" "+splitLine(i)+"\n"
        writer.write(line)
      }
      writer.close()
    }
  }
  

  def main(args: Array[String]) {
    readFile()
    writeFile()
    wordCount()
  }
}
