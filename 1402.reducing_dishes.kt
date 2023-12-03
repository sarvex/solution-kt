class Solution {
  fun maxSatisfaction(satisfaction: IntArray): Int {
    Arrays.sort(satisfaction)
    var ans = 0
    var s = 0
    for (i in satisfaction.indices.reversed()) {
      s += satisfaction[i]
      if (s <= 0) {
        break
      }
      ans += s
    }
    return ans
  }
}
