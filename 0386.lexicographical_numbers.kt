internal class Solution {
  fun lexicalOrder(n: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    var v = 1
    for (i in 0 until n) {
      ans.add(v)
      if (v * 10 <= n) {
        v *= 10
      } else {
        while (v % 10 == 9 || v + 1 > n) {
          v /= 10
        }
        ++v
      }
    }
    return ans
  }
}
