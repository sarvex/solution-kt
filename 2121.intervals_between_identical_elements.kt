internal class Solution {
  fun getDistances(arr: IntArray): LongArray {
    val d: Map<Int, List<Int>> = HashMap()
    val n = arr.size
    for (i in 0 until n) {
      d.computeIfAbsent(arr[i]) { k -> ArrayList() }.add(i)
    }
    val ans = LongArray(n)
    for (v in d.values()) {
      val m: Int = v.size()
      var `val`: Long = 0
      for (e in v) {
        `val` += e.toLong()
      }
      `val` -= m * v[0]
      for (i in 0 until v.size()) {
        val delta = if (i >= 1) v[i] - v[i - 1] else 0
        `val` += (i * delta - (m - i) * delta).toLong()
        ans[v[i]] = `val`
      }
    }
    return ans
  }
}
