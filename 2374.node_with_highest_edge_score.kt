class Solution {
  fun edgeScore(edges: IntArray): Int {
    val n = edges.size
    val cnt = LongArray(n)
    for (i in 0 until n) {
      cnt[edges[i]] += i.toLong()
    }
    var ans = 0
    for (i in 0 until n) {
      if (cnt[ans] < cnt[i]) {
        ans = i
      }
    }
    return ans
  }
}
