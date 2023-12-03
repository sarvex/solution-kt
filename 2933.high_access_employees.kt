class Solution {
  fun findHighAccessEmployees(access_times: List<List<String?>>): List<String> {
    val d: Map<String, List<Int>> = HashMap()
    for (e in access_times) {
      val name: String = e[0]
      val s: String = e[1]
      val t = s.substring(0, 2).toInt() * 60 + s.substring(2).toInt()
      d.computeIfAbsent(name) { k -> ArrayList() }.add(t)
    }
    val ans: List<String> = ArrayList()
    for (e in d.entrySet()) {
      val name: String = e.getKey()
      val ts: Unit = e.getValue()
      Collections.sort(ts)
      for (i in 2 until ts.size()) {
        if (ts.get(i) - ts.get(i - 2) < 60) {
          ans.add(name)
          break
        }
      }
    }
    return ans
  }
}
