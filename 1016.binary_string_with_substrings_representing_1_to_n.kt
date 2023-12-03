class Solution {
  fun queryString(s: String, n: Int): Boolean {
    if (n > 1023) {
      return false
    }
    for (i in n downTo n / 2 + 1) {
      if (!s.contains(Integer.toBinaryString(i))) {
        return false
      }
    }
    return true
  }
}
