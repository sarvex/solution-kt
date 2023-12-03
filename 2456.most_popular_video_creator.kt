import kotlin.math.max

class Solution {
  fun mostPopularCreator(creators: Array<String?>, ids: Array<String>, views: IntArray): List<List<String>> {
    val n = ids.size
    val cnt: Map<String, Long> = HashMap(n)
    val d: Map<String?, Int> = HashMap(n)
    for (k in 0 until n) {
      val c = creators[k]
      val i = ids[k]
      val v = views[k].toLong()
      cnt.merge(c, v) { a: Long, b: Long -> java.lang.Long.sum(a, b) }
      if (!d.containsKey(c) || views[d[c]!!] < v || views[d[c]!!].toLong() == v && ids[d[c]!!].compareTo(i) > 0) {
        d.put(c, k)
      }
    }
    var mx: Long = 0
    for (x in cnt.values()) {
      mx = max(mx.toDouble(), x.toDouble()).toLong()
    }
    val ans: List<List<String>> = ArrayList()
    for (e in cnt.entrySet()) {
      if (e.getValue() === mx) {
        val c: String = e.getKey()
        ans.add(List.of(c, ids[d[c]!!]))
      }
    }
    return ans
  }
}
