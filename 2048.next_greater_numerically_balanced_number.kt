internal class Solution {
  fun nextBeautifulNumber(n: Int): Int {
    for (i in n + 1..9999999) {
      if (check(i)) {
        return i
      }
    }
    return -1
  }

  private fun check(num: Int): Boolean {
    val counter = IntArray(10)
    val chars = num.toString().toCharArray()
    for (c in chars) {
      ++counter[c.code - '0'.code]
    }
    for (c in chars) {
      if (counter[c.code - '0'.code] != c.code - '0'.code) {
        return false
      }
    }
    return true
  }
}
