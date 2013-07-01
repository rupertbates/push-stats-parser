case class CsvLine(line : String) {
  val tokens = line split "\",\""
  def token(index : Int) = {
    tokens(index).replace("\"", "").trim
  }
}
