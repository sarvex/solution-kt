internal class Solution {
  fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val cnt = IntArray(100)
    var ans = 0
    for (e in dominoes) {
      val x = if (e[0] < e[1]) e[0] * 10 + e[1] else e[1] * 10 + e[0]
      ans += cnt[x]++
    }
    return ans
  }
}
