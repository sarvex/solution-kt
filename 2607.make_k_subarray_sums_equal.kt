import kotlin.math.abs

class Solution {
  fun makeSubKSumEqual(arr: IntArray, k: Int): Long {
    val n = arr.size
    val g = gcd(n, k)
    var ans: Long = 0
    for (i in 0 until g) {
      val t: List<Int> = ArrayList()
      var j = i
      while (j < n) {
        t.add(arr[j])
        j += g
      }
      t.sort { a, b -> a - b }
      val mid = t[t.size() shr 1]
      for (x in t) {
        (ans += abs((x - mid).toDouble())).toLong()
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
