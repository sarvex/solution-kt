internal class Solution {
  fun findDuplicate(paths: Array<String>): List<List<String>> {
    val d: Map<String, List<String>> = HashMap()
    for (p in paths) {
      val ps = p.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      for (i in 1 until ps.size) {
        val j = ps[i].indexOf('(')
        val content = ps[i].substring(j + 1, ps[i].length - 1)
        val name = ps[0] + '/' + ps[i].substring(0, j)
        d.computeIfAbsent(content) { k -> ArrayList() }.add(name)
      }
    }
    val ans: List<List<String>> = ArrayList()
    for (e in d.values()) {
      if (e.size() > 1) {
        ans.add(e)
      }
    }
    return ans
  }
}
