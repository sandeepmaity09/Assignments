trait ETL {
  private val dir = "."
  def getDir():String={ val dir = "." }
  def getFiles():List[file: java.io.File]
  def readFiles():Unit()
  def writeFiles():Unit()
  def wordCount():Map(String,Int)
}
