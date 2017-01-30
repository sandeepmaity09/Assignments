import java.io._

object Demo {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt"))
    writer.write("Hello Scala")
    writer.close()
  }
}
