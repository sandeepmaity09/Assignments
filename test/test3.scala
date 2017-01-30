//Reading File Content

import scala.io.Source

object Demo {
  def main(args: Array[String]) {
    println("Following is the content read: ")
    Source.fromFile("test.txt").foreach {
      print
    }
  }
}
