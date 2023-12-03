class Solution {
  fun beautifulArray(n: Int): IntArray {
    if (n == 1) {
      return intArrayOf(1)
    }
    val left = beautifulArray(n + 1 shr 1)
    val right = beautifulArray(n shr 1)
    val ans = IntArray(n)
    var i = 0
    for (x in left) {
      ans[i++] = x * 2 - 1
    }
    for (x in right) {
      ans[i++] = x * 2
    }
    return ans
  }
}
