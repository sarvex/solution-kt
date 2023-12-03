internal class Solution {
  fun mirrorReflection(p: Int, q: Int): Int {
    var p = p
    var q = q
    val g = gcd(p, q)
    p = p / g % 2
    q = q / g % 2
    if (p == 1 && q == 1) {
      return 1
    }
    return if (p == 1) 0 else 2
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
