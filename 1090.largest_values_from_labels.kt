internal class Solution {
  fun largestValsFromLabels(values: IntArray, labels: IntArray, numWanted: Int, useLimit: Int): Int {
    val n = values.size
    val pairs = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      pairs[i] = intArrayOf(values[i], labels[i])
    }
    Arrays.sort(pairs) { a, b -> b.get(0) - a.get(0) }
    val cnt: Map<Int, Int> = HashMap()
    var ans = 0
    var num = 0
    var i = 0
    while (i < n && num < numWanted) {
      val v = pairs[i][0]
      val l = pairs[i][1]
      if (cnt[l] ?: 0 < useLimit) {
        cnt.merge(l, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        num += 1
        ans += v
      }
      ++i
    }
    return ans
  }
}
