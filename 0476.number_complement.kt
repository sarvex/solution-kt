internal class Solution {
  fun findComplement(num: Int): Int {
    var ans = 0
    var find = false
    for (i in 30 downTo 0) {
      val b = num and (1 shl i)
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
