import org.joda.time.DateTime

case class DataPoint(date : DateTime, dailyUniques : Int, notifications : List[PushNotification] = Nil) {
  val quote = "'"
  val delimiter = ","
  override def toString: String = {
    val headlines = notifications.foldLeft("")((acc, v) => acc + v.message + "\\n")
    val output = headlines.take(headlines.size - "\\n".length
    ).replace("'", "\\'")
    val noHyphens = output.replace("–", ":")
    println(output)
    "[" + quote + date.toString("d/MMMM/yyyy") + quote + delimiter + dailyUniques + delimiter + quote + noHyphens + quote + "],"
  }
}
