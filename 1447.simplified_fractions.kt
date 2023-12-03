class Solution {
  fun simplifiedFractions(n: Int): List<String> {
    val ans: List<String> = ArrayList()
    for (i in 1 until n) {
      for (j in i + 1 until n + 1) {
        if (gcd(i, j) == 1) {
          ans.add("$i/$j")
        }
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b > 0) gcd(b, a % b) else a
  }
}
