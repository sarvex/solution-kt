class Solution {
  fun minFlips(target: String): Int {
    var ans = 0
    for (i in 0 until target.length) {
      val v = target[i].code - '0'.code
      if (ans and 1 xor v != 0) {
        ++ans
      }
    }
    return ans
  }
}
