class Solution {
  fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
    val d: TreeMap<Int, Long> = TreeMap()
    for (e in segments) {
      val l = e[0]
      val r = e[1]
      val c = e[2]
      d.put(l, d.getOrDefault(l, 0L) + c)
      d.put(r, d.getOrDefault(r, 0L) - c)
    }
    val ans: List<List<Long>> = ArrayList()
    var i: Long = 0
    var j: Long = 0
    var cur: Long = 0
    for (e in d.entrySet()) {
      if (Objects.equals(e.getKey(), d.firstKey())) {
        i = e.getKey()
      } else {
        j = e.getKey()
        if (cur > 0) {
          ans.add(Arrays.asList(i, j, cur))
        }
        i = j
      }
      cur += e.getValue()
    }
    return ans
  }
}
