class Solution {
  fun getNoZeroIntegers(n: Int): IntArray {
    var a = 1
    while (true) {
      val b = n - a
      if (!(a.toString() + "" + b).contains("0")) {
        return intArrayOf(a, b)
      }
      ++a
    }
  }
}
