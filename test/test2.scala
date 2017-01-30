//Reading a line from command line
import java.io._
object Demo {
  def main(args: Array[String]) {
    print("Please enter your input : ")
    val line = Console.readLine

    println("Thanks, you just typed: "+line)
  }
}
