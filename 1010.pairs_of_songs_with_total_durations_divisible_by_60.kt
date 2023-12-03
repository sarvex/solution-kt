internal class Solution {
  fun numPairsDivisibleBy60(time: IntArray): Int {
    val cnt = IntArray(60)
    for (t in time) {
      ++cnt[t % 60]
    }
    var ans = 0
    for (x in 1..29) {
      ans += cnt[x] * cnt[60 - x]
    }
    ans += (cnt[0].toLong() * (cnt[0] - 1) / 2).toInt()
    ans += (cnt[30].toLong() * (cnt[30] - 1) / 2).toInt()
    return ans
  }
}
