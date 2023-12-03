internal class Solution {
  fun mostVisitedPattern(username: Array<String?>, timestamp: IntArray, website: Array<String?>): List<String> {
    val d: Map<String, List<Node>> = HashMap()
    val n = username.size
    for (i in 0 until n) {
      val user = username[i]
      val ts = timestamp[i]
      val site = website[i]
      d.computeIfAbsent(user) { k -> ArrayList() }.add(Node(user, ts, site))
    }
    val cnt: Map<String, Int> = HashMap()
    for (sites in d.values()) {
      val m: Int = sites.size()
      val s: Set<String> = HashSet()
      if (m > 2) {
        Collections.sort(sites) { a, b -> a.ts - b.ts }
        for (i in 0 until m - 2) {
          for (j in i + 1 until m - 1) {
            for (k in j + 1 until m) {
              s.add(
                (sites.get(i).site + "," + sites.get(j).site).toString() + ","
                    + sites.get(k).site
              )
            }
          }
        }
      }
      for (t in s) {
        cnt.put(t, (cnt[t] ?: 0) + 1)
      }
    }
    var mx = 0
    var t = ""
    for (e in cnt.entrySet()) {
      if (mx < e.getValue() || mx == e.getValue() && e.getKey().compareTo(t) < 0) {
        mx = e.getValue()
        t = e.getKey()
      }
    }
    return Arrays.asList(t.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
  }
}

internal open class Node(var user: String, var ts: Int, var site: String) 
