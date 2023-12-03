internal class Solution {
  fun numJewelsInStones(jewels: String, stones: String): Int {
    val s = IntArray(128)
    for (c in jewels.toCharArray()) {
      s[c.code] = 1
    }
    var ans = 0
    for (c in stones.toCharArray()) {
      ans += s[c.code]
    }
    return ans
  }
}
