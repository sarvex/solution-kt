class Solution {
  fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val cnt1 = IntArray(n + 1)
    val cnt2 = IntArray(n + 1)
    for (t in trust) {
      val a = t[0]
      val b = t[1]
      ++cnt1[a]
      ++cnt2[b]
    }
    for (i in 1..n) {
      if (cnt1[i] == 0 && cnt2[i] == n - 1) {
        return i
      }
    }
    return -1
  }
}
