internal class Solution {
  fun findRelativeRanks(score: IntArray): Array<String?> {
    val n = score.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i1, i2 -> score[i2] - score[i1] }
    val ans = arrayOfNulls<String>(n)
    val top3 = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")
    for (i in 0 until n) {
      ans[idx[i]!!] = if (i < 3) top3[i] else (i + 1).toString()
    }
    return ans
  }
}
