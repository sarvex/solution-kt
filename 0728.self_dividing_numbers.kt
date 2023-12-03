internal class Solution {
  fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in left..right) {
      if (check(i)) {
        ans.add(i)
      }
    }
    return ans
  }

  private fun check(num: Int): Boolean {
    var t = num
    while (t != 0) {
      val x = t % 10
      if (x == 0 || num % x != 0) {
        return false
      }
      t /= 10
    }
    return true
  }
}
