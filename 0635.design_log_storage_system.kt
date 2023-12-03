internal class LogSystem {
  private val logs: List<Log> = ArrayList()
  private val d: Map<String, Int> = HashMap()

  init {
    d.put("Year", 4)
    d.put("Month", 7)
    d.put("Day", 10)
    d.put("Hour", 13)
    d.put("Minute", 16)
    d.put("Second", 19)
  }

  fun put(id: Int, timestamp: String?) {
    logs.add(Log(id, timestamp))
  }

  fun retrieve(start: String, end: String, granularity: String): List<Int> {
    val ans: List<Int> = ArrayList()
    val i = d[granularity]!!
    val s = start.substring(0, i)
    val e = end.substring(0, i)
    for (log in logs) {
      val t = log.ts.substring(0, i)
      if (s.compareTo(t) <= 0 && t.compareTo(e) <= 0) {
        ans.add(log.id)
      }
    }
    return ans
  }
}

internal class Log(var id: Int, var ts: String?)
