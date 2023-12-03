class Solution {
  fun minFlips(a: Int, b: Int, c: Int): Int {
    var ans = 0
    for (i in 0..29) {
      val x = a shr i and 1
      val y = b shr i and 1
      val z = c shr i and 1
      if (x or y != z) {
        ans += if (x == 1 && y == 1) 2 else 1
      }
    }
    return ans
  }
}
