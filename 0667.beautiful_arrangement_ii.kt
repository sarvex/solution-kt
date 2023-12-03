internal class Solution {
  fun constructArray(n: Int, k: Int): IntArray {
    var l = 1
    var r = n
    val ans = IntArray(n)
    for (i in 0 until k) {
      ans[i] = if (i % 2 == 0) l++ else r--
    }
    for (i in k until n) {
      ans[i] = if (k % 2 == 0) r-- else l++
    }
    return ans
  }
}
