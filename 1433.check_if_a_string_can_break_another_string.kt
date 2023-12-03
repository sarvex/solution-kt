class Solution {
  fun checkIfCanBreak(s1: String, s2: String): Boolean {
    val cs1 = s1.toCharArray()
    val cs2 = s2.toCharArray()
    Arrays.sort(cs1)
    Arrays.sort(cs2)
    return check(cs1, cs2) || check(cs2, cs1)
  }

  private fun check(cs1: CharArray, cs2: CharArray): Boolean {
    for (i in cs1.indices) {
      if (cs1[i] < cs2[i]) {
        return false
      }
    }
    return true
  }
}
