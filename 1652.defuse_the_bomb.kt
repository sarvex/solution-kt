class Solution {
  fun decrypt(code: IntArray, k: Int): IntArray {
    val n = code.size
    val ans = IntArray(n)
    if (k == 0) {
      return ans
    }
    val s = IntArray(n shl 1 or 1)
    for (i in 0 until (n shl 1)) {
      s[i + 1] = s[i] + code[i % n]
    }
    for (i in 0 until n) {
      if (k > 0) {
        ans[i] = s[i + k + 1] - s[i + 1]
      } else {
        ans[i] = s[i + n] - s[i + k + n]
      }
    }
    return ans
  }
}
