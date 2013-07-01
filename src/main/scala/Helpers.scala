object Helpers {
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
  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }
}
