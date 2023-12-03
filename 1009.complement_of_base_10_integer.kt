internal class Solution {
  fun bitwiseComplement(n: Int): Int {
    if (n == 0) {
      return 1
    }
    var ans = 0
    var find = false
    for (i in 30 downTo 0) {
      val b = n and (1 shl i)
      if (!find && b == 0) {
        continue
      }
      find = true
      if (b == 0) {
        ans = ans or (1 shl i)
      }
    }
    return ans
  }
}
