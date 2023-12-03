class Solution {
  fun minChanges(nums: IntArray, k: Int): Int {
    val n = 1 shl 10
    val cnt: Array<Map<Int, Int>?> = arrayOfNulls(k)
    Arrays.setAll(cnt) { i -> HashMap() }
    val size = IntArray(k)
    for (i in nums.indices) {
      val j = i % k
      cnt[j].merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      size[j]++
    }
    var f = IntArray(n)
    val inf = 1 shl 30
    Arrays.fill(f, inf)
    f[0] = 0
    for (i in 0 until k) {
      val g = IntArray(n)
      Arrays.fill(g, min(f) + size[i])
      for (j in 0 until n) {
        for (e in cnt[i].entrySet()) {
          val v: Int = e.getKey()
          val c: Int = e.getValue()
          g[j] = kotlin.math.min(g[j].toDouble(), (f[j xor v] + size[i] - c).toDouble()).toInt()
        }
      }
      f = g
    }
    return f[0]
  }

  private fun min(arr: IntArray): Int {
    var mi = arr[0]
    for (v in arr) {
      mi = kotlin.math.min(mi.toDouble(), v.toDouble()).toInt()
    }
    return mi
  }
}
