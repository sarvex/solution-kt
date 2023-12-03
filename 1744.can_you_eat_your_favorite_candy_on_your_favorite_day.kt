class Solution {
  fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {
    val n = candiesCount.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + candiesCount[i]
    }
    val m = queries.size
    val ans = BooleanArray(m)
    for (i in 0 until m) {
      val t = queries[i][0]
      val day = queries[i][1]
      val mx = queries[i][2]
      val least = day.toLong()
      val most = (day + 1).toLong() * mx
      ans[i] = least < s[t + 1] && most > s[t]
    }
    return ans
  }
}
