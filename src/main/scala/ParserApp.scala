import java.io.File
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import scala.io.Source
import Helpers._


object ParserApp extends App {

  val flurryPattern = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm")
  val pushyPattern = DateTimeFormat.forPattern("EEEE, d MMMM yyyy - HH:mm:ss")
  val liveDate = new DateTime(2013, 1, 23, 0, 0, 0) //date the service went live to real users
  val noPushes = List(new PushNotification(DateTime.now(), "No push sent"))
  override def main(args: Array[String]) {
    super.main(args)

    val pushes = Source.fromFile("data/public_export_stats.csv")
      .getLines()
      .toList
      .filter(!_.startsWith("\"Time"))
      .map {
      line =>
      val tokens = CsvLine(line)
      val date = pushyPattern.parseDateTime(tokens.token(0)).toDateMidnight.toDateTime
      PushNotification(date, tokens.token(1))
    }.filter(p => p.date.isAfter(liveDate))

    val distinct = pushes.distinctBy(_.message)
    val grouped = distinct groupBy(_.date)

    //grouped.foreach(p => println(p._1 + " " + p._2(0).message))

    val dataPoints = Source.fromFile("data/AndroidNews-2013_07_01-activeUsers.csv")
      .getLines()
      .filter(!_.startsWith("Incomplete"))
      .toList
      .reverse
      .map {
      line =>
        val tokens = CsvLine(line)
        val date = flurryPattern.parseDateTime(tokens.token(1)).toDateMidnight.toDateTime()
        val pushes = grouped.getOrElse(date, noPushes)
        DataPoint(date, tokens.token(2).toInt, pushes)
    }

    val output = new File("chart.html")
    if (output.exists()) output.delete()
    printToFile(output)(p => {
      p.println(Templates.head)
      dataPoints.foreach(p.println)
      p.println(Templates.tail)
    })

  }
}
