import org.joda.time.{DateMidnight, DateTime}
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

val data = List(("Wednesday, 26 June 2013 - 15:53:59", "Supreme court dismisses Proposition 8"),
("Wednesday, 26 June 2013 - 15:18:54", "US supreme court rules Defense of Marriage Act unconstitutional – live updates"),
("Wednesday, 26 June 2013 - 11:12:23", "Julia Gillard loses Labor leadership to Kevin Rudd"),
("Tuesday, 25 June 2013 - 16:31:44", "Putin: Snowden in Moscow airport transit zone"),
("Tuesday, 25 June 2013 - 15:42:54", "Glastonbury contest: win a trip to Bolivia"),
("Tuesday, 25 June 2013 - 15:29:57", "Glastonbury contest: win a trip to Bolivia"),
("Monday, 24 June 2013 - 21:16:28", "Scotland Yard spied on critics of police corruption"),
("Friday, 21 June 2013 - 17:28:52", "GCHQ taps fibre-optic cables for secret access to world's communications"),
("Friday, 21 June 2013 - 15:08:39", "McLibel leaflet was co-written by undercover police officer"),
("Friday, 21 June 2013 - 13:19:10", "Jeremy Forrest jailed for pupil abduction and sexual offences"),
("Thursday, 20 June 2013 - 07:54:48", "Actor James Gandolfini dies aged 51"),
("Monday, 17 June 2013 - 13:12:36", "Stuart Hall jailed for indecently assaulting young girls"),
("Sunday, 16 June 2013 - 20:57:44", "GCHQ intercepted foreign politicians' communications at G20 summits"),
("Saturday, 15 June 2013 - 17:30:44", "Iranian cleric Hassan Rouhani elected as president"),
("Thursday, 13 June 2013 - 17:25:42", "Police killer Cregan told he will die in prison"),
("Wednesday, 12 June 2013 - 10:02:57", "David Warner axed after 'Joe Root confrontation'"),
("Wednesday, 12 June 2013 - 10:00:20", "David Warner axed after 'Joe Root confrontation'"),
("Sunday, 9 June 2013 - 20:01:47", "NSA surveillance whistleblower explains motives"),
("Sunday, 9 June 2013 - 17:33:27", "Author Iain Banks dies aged 59"),
("Saturday, 8 June 2013 - 20:50:20", "Revealed: NSA's tool to track surveillance data"),
("Friday, 7 June 2013 - 20:16:46", "Obama orders US to draw up overseas target list for cyber-attacks"),
("Friday, 7 June 2013 - 14:51:48", "UK gathering secret intelligence via covert NSA operation"),
("Thursday, 6 June 2013 - 23:20:20", "NSA taps in to internet giants' systems to mine user data, secret files reveal"),
("Thursday, 6 June 2013 - 15:59:42", "Obama administration defends NSA collection of Verizon phone records"),
("Thursday, 6 June 2013 - 00:23:08", "Revealed: NSA collecting phone records of millions of Americans daily"),
("Wednesday, 5 June 2013 - 13:08:17", "Susan Rice to replace Tom Donilon as US national security adviser"),
("Wednesday, 5 June 2013 - 13:02:15", "Susan Rice to replace Tom Donilon as US national security adviser"),
("Wednesday, 5 June 2013 - 12:39:17", "Rebekah Brooks pleads not guilty to charges"),
("Sunday, 2 June 2013 - 17:02:10", "Michael Douglas: oral sex caused my cancer"),
("Thursday, 30 May 2013 - 12:22:07", "Bridger guilty of April murder"),
("Thursday, 30 May 2013 - 08:55:10", "Missing teenager: suspect arrested"),
("Thursday, 30 May 2013 - 00:04:23", "Woolwich attack: Michael Adebowale charged with murder of Lee Rigby"),
("Thursday, 23 May 2013 - 17:10:51", "Woolwich victim named as Lee Rigby"),
("Thursday, 23 May 2013 - 13:59:59", "Woolwich suspect identified as Michael Adebolajo"),
("Thursday, 23 May 2013 - 12:08:44", "Woolwich terror attack suspect named as Michael Adebolajo"),
("Wednesday, 22 May 2013 - 19:01:10", "Footage emerges of suspect in Woolwich attack"),
("Wednesday, 22 May 2013 - 17:55:25", "Government to Ministers hold emergency 'Cobra' meeting after fatal attack in south London street"),
("Wednesday, 22 May 2013 - 16:58:22", "Two people shot after police respond to alleged 'machete attack' in Woolwich"),
("Wednesday, 22 May 2013 - 14:21:30", "UK provided more support for CIA rendition flights than thought – study"),
("Monday, 20 May 2013 - 23:07:50", "Gay marriage plans set to proceed"),
("Monday, 20 May 2013 - 22:05:47", "Apple accused of avoiding billions in tax"),
("Monday, 20 May 2013 - 10:57:19", "Father of Gary and Phil Neville faces sexual assault charge"),
("Thursday, 16 May 2013 - 15:24:32", "David Beckham to retire from football"),
("Wednesday, 15 May 2013 - 17:14:17", "Google I/O 2013 keynote – live blog"),
("Monday, 13 May 2013 - 16:41:13", "Obama and Cameron press conference – live blog"),
("Sunday, 12 May 2013 - 22:00:28", "TV Baftas 2013: all the winners"),
("Friday, 10 May 2013 - 15:46:46", "Woman found alive in Dhaka rubble 17 days on"),
("Thursday, 9 May 2013 - 08:28:41", "Prince Charles attacks global warming sceptics"),
("Wednesday, 8 May 2013 - 09:49:45", "Sir Alex Ferguson retires as Manchester United manager"),
("Saturday, 4 May 2013 - 10:33:26", "Israel 'bombs Syrian weapons convoy'"),
("Thursday, 2 May 2013 - 10:54:49", "Stuart Hall admits to sexual abuse of girls"),
("Wednesday, 1 May 2013 - 17:47:53", "Three arrests in Boston bomb investigation"),
("Wednesday, 1 May 2013 - 11:07:51", "Actor Bill Roache arrested on suspicion of raping girl"),
("Wednesday, 1 May 2013 - 07:18:34", "Afghan blast kills British troops"),
("Tuesday, 30 April 2013 - 10:09:28", "Queen Beatrix abdicates Dutch throne - live"),
("Monday, 29 April 2013 - 18:10:52", "NBA star comes out"),
("Friday, 26 April 2013 - 19:11:33", "Max Clifford charged with indecent assault"),
("Thursday, 25 April 2013 - 15:30:37", "Justin Bieber tour bus raided for drugs"),
("Thursday, 25 April 2013 - 10:02:26", "Britain avoids triple-dip recession – live updates"),
("Wednesday, 24 April 2013 - 20:02:43", "Trust in EU at record low"),
("Wednesday, 24 April 2013 - 12:19:14", "Abu Qatada: UK may quit European rights convention"),
("Wednesday, 24 April 2013 - 11:44:54", "Surrey police had 'collective amnesia' over Milly Dowler phone hacking"),
("Saturday, 20 April 2013 - 21:58:40", "UK Guantánamo resident 'may never be allowed home'"),
("Saturday, 20 April 2013 - 01:49:28", "Second Boston bombing suspect found alive in boat"),
("Friday, 19 April 2013 - 13:39:43", "Boston bombing suspects named - live updates"),
("Friday, 19 April 2013 - 07:59:05", "Boston: MIT police officer shot dead and armed drama in Watertown - live"),
("Thursday, 18 April 2013 - 12:09:14", "Chris Hoy confirms retirement from cycling"),
("Thursday, 18 April 2013 - 08:40:16", "Texas explosion: fatalities confirmed at fertiliser plant"),
("Wednesday, 17 April 2013 - 12:44:15", "Thatcher funeral - live updates"),
("Tuesday, 16 April 2013 - 15:25:00", " NEW! GuardianWitness: our new home for content you've created"),
("Tuesday, 16 April 2013 - 13:11:03", "Huge earthquake hits Iran-Pakistan border"),
("Monday, 15 April 2013 - 20:41:03", "Explosions at Boston marathon – live updates"),
("Monday, 15 April 2013 - 18:37:06", "Update available"),
("Monday, 15 April 2013 - 15:53:33", "Big Ben to be silenced for Thatcher funeral"),
("Monday, 15 April 2013 - 15:36:57", "Mid Staffs NHS trust put into administration"),
("Wednesday, 10 April 2013 - 11:50:49", "Egypt's army took part in torture and killings, report shows"),
("Tuesday, 9 April 2013 - 11:05:31", "Thatcher's funeral to take place next Wednesday"),
("Monday, 8 April 2013 - 14:04:32", "Margaret Thatcher dies aged 87 - live updates"),
("Monday, 8 April 2013 - 14:04:04", "Margaret Thatcher dies aged 87 - live updates"),
("Thursday, 4 April 2013 - 17:52:04", "Facebook to unveil 'new home on Android' – live blog"),
("Thursday, 4 April 2013 - 11:12:36", "Father jailed for life over Derby house fire deaths"),
("Wednesday, 3 April 2013 - 14:20:38", "Rolling Stones back at Hyde Park after 44 years"),
("Tuesday, 26 March 2013 - 22:09:48", "David Miliband to step down as MP"),
("Tuesday, 26 March 2013 - 09:29:08", "Amanda Knox faces retrial over Meredith Kercher murder"),
("Tuesday, 26 March 2013 - 07:30:50", "North Korea orders rockets into 'combat mode'"),
("Monday, 25 March 2013 - 01:29:51", "Cyprus strikes bailout deal with EU"),
("Saturday, 23 March 2013 - 18:55:37", "Boris Berezovsky found dead"),
("Wednesday, 20 March 2013 - 12:32:26", "Budget 2013 - live"),
("Friday, 15 March 2013 - 22:43:16", "Phone hacking: Murdoch hit by 600 claims"),
("Thursday, 14 March 2013 - 22:57:29", "Samsung Galaxy S4 launch - live coverage"),
("Tuesday, 12 March 2013 - 08:05:17", "Falklands vote 'yes' to staying British"),
("Monday, 11 March 2013 - 17:06:28", "Chris Huhne and Vicky Pryce jailed"),
("Sunday, 3 March 2013 - 23:15:06", "Child born with HIV cured"),
("Friday, 1 March 2013 - 02:59:11", "Lib Dems win Eastleigh byelection"),
("Thursday, 28 February 2013 - 21:33:28", "Hague: don't mention Iraq war"),
("Thursday, 28 February 2013 - 15:28:10", "Pope's last day in office - live updates"),
("Monday, 25 February 2013 - 11:33:55", "Cardinal Keith O'Brien resigns"),
("Monday, 25 February 2013 - 09:24:00", "Oscars: Argo wins best picture"),
("Monday, 25 February 2013 - 01:25:50", "Oscars 2013: live coverage!"),
("Friday, 22 February 2013 - 22:25:47", "UK's credit rating downgraded"),
("Friday, 22 February 2013 - 14:26:27", "Pistorius granted bail - live coverage"),
("Thursday, 21 February 2013 - 07:19:58", "Oscar Pistorius case: lead investigator is facing gun charges"),
("Wednesday, 20 February 2013 - 22:23:27", "PlayStation 4: Sony unveils new console – live"),
("Wednesday, 20 February 2013 - 20:07:33", "Brit awards live blog"),
("Wednesday, 20 February 2013 - 14:29:14", "Vicky Pryce jury discharged"),
("Wednesday, 20 February 2013 - 09:13:12", "Pistorius bail hearing day two – live coverage"),
("Monday, 18 February 2013 - 20:41:26", "Nuclear reactor deal until 2050 offered"),
("Friday, 15 February 2013 - 09:35:24", "Meteorite explosion over Russia injures hundreds - live updates"),
("Thursday, 14 February 2013 - 11:01:03", "Horsemeat scandal deepens as minister admits bute may be in food chain"),
("Wednesday, 13 February 2013 - 18:41:22", "Journalists arrested in hacking inquiry named"),
("Tuesday, 12 February 2013 - 19:46:43", "Horsemeat: two companies raided"),
("Monday, 11 February 2013 - 11:39:45", "Pope resigns – live reaction"),
("Sunday, 10 February 2013 - 18:47:22", "Baftas 2013 – live!"),
("Sunday, 10 February 2013 - 16:12:26", "Defence firm's software tracks people on social media"),
("Friday, 8 February 2013 - 16:35:53", "EU agrees historic budget deal - live updates"),
("Friday, 8 February 2013 - 15:53:30", "Choirmaster trial victim killed herself after giving evidence"),
("Tuesday, 5 February 2013 - 19:15:58", "Gay marriage bill passed by MPs"),
("Tuesday, 5 February 2013 - 10:12:58", "Rebecca Adlington retires"),
("Monday, 4 February 2013 - 10:45:44", "Skeleton is of Richard III, scientists confirm"),
("Sunday, 3 February 2013 - 23:06:41", "Karzai exclusive interview"),
("Sunday, 3 February 2013 - 19:02:24", "Police spies stole identities of dead children"),
("Sunday, 3 February 2013 - 10:07:08", "My Bloody Valentine release new album"),
("Friday, 1 February 2013 - 22:05:24", "Charlie Sheen interview"),
("Friday, 1 February 2013 - 13:50:20", "US adds 157,000 jobs in January"),
("Thursday, 31 January 2013 - 13:14:32", "Transfer deadline day – live updates"),
("Wednesday, 30 January 2013 - 22:26:17", "Hospitals face new army of inspectors"),
("Tuesday, 29 January 2013 - 21:18:55", "Families face diabetes drug battle"),
("Tuesday, 29 January 2013 - 17:13:31", "Cameron to visit Algeria"),
("Tuesday, 29 January 2013 - 13:39:59", "Bay of Bengal's vanishing islands"),
("Tuesday, 22 January 2013 - 23:04:55", "In-out EU referendum by end of 2017"),
("Monday, 21 January 2013 - 19:32:32", "Prince Harry finishes Afghan tour"),
("Monday, 21 January 2013 - 17:40:43", "Obama publicly sworn in for second term"),
("Monday, 21 January 2013 - 14:40:22", "Michael Winner dies"),
("Sunday, 20 January 2013 - 00:00:06", "Britain, torture and Iraq: special report"),
("Friday, 18 January 2013 - 21:01:24", "Exclusive interview with internet cult hero Kim Dotcom"),
("Friday, 18 January 2013 - 11:13:56", "Snow hits UK - live updates"),
("Thursday, 17 January 2013 - 17:01:53", "Algerian hostage crisis – live updates"),
("Thursday, 17 January 2013 - 10:27:04", "US election: Obama victory celebrations – in pictures"),
("Thursday, 17 January 2013 - 10:24:48", "Picture desk live: the best news pictures of the day"),
("Thursday, 17 January 2013 - 10:23:37", "Picture desk live: the best news pictures of the day"),
("Thursday, 17 January 2013 - 09:56:50", "Algerian Islamists hold western hostages – live updates"),
("Thursday, 17 January 2013 - 08:59:00", "Miliband: Europe not working well for us"),
("Wednesday, 16 January 2013 - 15:22:05", "Picture desk live: the best news pictures of the day"),
("Wednesday, 16 January 2013 - 08:41:15", "Helicopter crashes in central London"),
("Thursday, 10 January 2013 - 14:22:56", "13 Oscar nominations for Lincoln"),
("Thursday, 10 January 2013 - 10:56:12", "Australian wildfires: clinging to life"),
("Thursday, 10 January 2013 - 10:49:29", "World throws away half its food"),
("Wednesday, 9 January 2013 - 15:07:38", "Norovirus: new strain may be behind 63% increase in cases"),
("Wednesday, 9 January 2013 - 12:43:45", "Lance Armstrong will break silence with Oprah Winfrey interview"),
("Wednesday, 9 January 2013 - 11:47:06", "PMQs and release of the coalition's pledge audit: Politics live blog"),
("Wednesday, 9 January 2013 - 11:43:20", "Grayling defends probation privatisation"),
("Tuesday, 8 January 2013 - 17:20:42", "Drone arms race in Asia"),
("Tuesday, 8 January 2013 - 15:57:53", "Benefits debate - follow live"),
("Tuesday, 8 January 2013 - 15:57:29", "David Bowie: still the man of mystique"),
("Tuesday, 8 January 2013 - 15:32:43", " MPs vote on 1% benefits cap: live"),
("Monday, 7 January 2013 - 17:15:12", "The new Bermuda Triangle"),
("Monday, 7 January 2013 - 16:45:41", "Is Mr Selfridge the new Downton?"),
("Monday, 7 January 2013 - 16:38:28", "Ex-Obama adviser says drone strikes are 'counter-productive'"),
("Monday, 7 January 2013 - 16:22:42", "Coalition's 'Ronseal deal'"),
("Monday, 7 January 2013 - 16:17:43", "Lord Strathclyde resigns as leader of House of Lords"),
("Monday, 7 January 2013 - 16:17:18", "Festive flora and fauna – your Green shoots photographs"),
("Monday, 7 January 2013 - 16:16:24", "Festive flora and fauna – your Green shoots photographs"),
("Monday, 7 January 2013 - 16:15:30", "Festive flora and fauna – your Green shoots photographs"),
("Monday, 7 January 2013 - 16:13:13", "Lord Strathclyde resigns as leader of House of Lords"),
("Monday, 7 January 2013 - 16:08:03", "Stuart Hall denies sexual abuse of three girls"),
("Monday, 7 January 2013 - 16:06:46", "Stuart Hall denies sexual abuse of three girls"),
("Monday, 7 January 2013 - 16:04:40", "Lord Strathclyde resigns as leader of House of Lords"),
("Monday, 7 January 2013 - 14:57:46", "Coalition's mid-term review"),
("Monday, 7 January 2013 - 14:55:17", "Cameron and Clegg publish coalition's mid-term review: Politics live blog"),
("Monday, 7 January 2013 - 12:37:23", "Cameron and Clegg renew coalition vows with 'sense of shared purpose'"),
("Wednesday, 2 January 2013 - 17:30:02", "Custom push test"),
("Wednesday, 2 January 2013 - 14:49:19", "Syria conflict: - live updates"),
("Wednesday, 2 January 2013 - 14:46:40", "Syria conflict: - live updates"))











implicit def dateTimeOrdering: Ordering[DateMidnight] = Ordering.fromLessThan(_ isAfter _)




implicit def seq2Distinct[T, C[T] <: Seq[T]](tees: C[T]) = new {
  import collection.generic.CanBuildFrom
  import collection.mutable.{HashSet => MutableHashSet}

  def distinctBy[S](hash: T => S)(implicit cbf: CanBuildFrom[C[T],T,C[T]]): C[T] = {
    val builder = cbf()
    val seen = MutableHashSet[S]()
    for (t <- tees) {
      if (!seen(hash(t))) {
        builder += t
        seen += hash(t)
      }
    }
    builder.result
  }
}





val dtf = DateTimeFormat.forPattern("EEEE, d MMMM yyyy - HH:mm:ss")


val parsed = data map(d => ( dtf.parseDateTime(d._1).toDateMidnight, d._2))










val distinct = parsed.distinctBy{_._2}










val grouped = distinct.groupBy(_._1)










val ordered = grouped.toList.sortBy(_._1)













ordered.foreach{
  d =>
    val headlines = d._2.foldLeft("")((acc, v) => acc + v._2 + ",")
    println("\"" + d._1.toString("M/d/yyyy") + "\",\"" + headlines.take(headlines.size - 1) + "\"")
}





























































































































































