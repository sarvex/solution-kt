class Solution {
  fun findArray(pref: IntArray): IntArray {
    val n = pref.size
    val ans = IntArray(n)
    ans[0] = pref[0]
    for (i in 1 until n) {
      ans[i] = pref[i - 1] xor pref[i]
    }
    return ans
  }
}
