class Solution {
  fun alertNames(keyName: Array<String?>, keyTime: Array<String>): List<String> {
    val d: Map<String, List<Int>> = HashMap()
    for (i in keyName.indices) {
      val name = keyName[i]
      val time = keyTime[i]
      val t = time.substring(0, 2).toInt() * 60 + time.substring(3).toInt()
      d.computeIfAbsent(name) { k -> ArrayList() }.add(t)
    }
    val ans: List<String> = ArrayList()
    for (e in d.entrySet()) {
      val ts: Unit = e.getValue()
      val n: Int = ts.size()
      if (n > 2) {
        Collections.sort(ts)
        for (i in 0 until n - 2) {
          if (ts.get(i + 2) - ts.get(i) <= 60) {
            ans.add(e.getKey())
            break
          }
        }
      }
    }
    Collections.sort(ans)
    return ans
  }
}
