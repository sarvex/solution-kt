class Solution {
  fun findLatestStep(arr: IntArray, m: Int): Int {
    val n = arr.size
    if (m == n) {
      return n
    }
    val cnt = IntArray(n + 2)
    var ans = -1
    for (i in 0 until n) {
      val v = arr[i]
      val l = cnt[v - 1]
      val r = cnt[v + 1]
      if (l == m || r == m) {
        ans = i
      }
      cnt[v - l] = l + r + 1
      cnt[v + r] = l + r + 1
    }
    return ans
  }
}
