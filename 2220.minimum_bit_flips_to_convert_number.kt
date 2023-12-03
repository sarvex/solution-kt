class Solution {
  fun minBitFlips(start: Int, goal: Int): Int {
    var t = start xor goal
    var ans = 0
    while (t != 0) {
      ans += t and 1
      t = t shr 1
    }
    return ans
  }
}
