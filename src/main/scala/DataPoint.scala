import org.joda.time.DateTime

case class DataPoint(date : DateTime, dailyUniques : Int, notifications : List[PushNotification] = Nil) {
  val comma = "\""
  val delimiter = comma + "," + comma
  override def toString: String = {
    val headlines = notifications.foldLeft("")((acc, v) => acc + v.message + ",")
    comma + date.toString("d/MMM/yyyy") + delimiter + dailyUniques + delimiter + headlines.take(50) + comma
  }
}
