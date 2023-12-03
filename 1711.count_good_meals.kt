class Solution {
  fun countPairs(deliciousness: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (d in deliciousness) {
      cnt.put(d, (cnt[d] ?: 0) + 1)
    }
    var ans: Long = 0
    for (i in 0..21) {
      val s = 1 shl i
      for (x in cnt.entrySet()) {
        val a: Int = x.getKey()
        val m: Int = x.getValue()
        val b = s - a
        if (!cnt.containsKey(b)) {
          continue
        }
        ans += 1L * m * (if (a == b) m - 1 else cnt[b])!!
      }
    }
    ans = ans shr 1
    return (ans % Solution.Companion.MOD).toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
