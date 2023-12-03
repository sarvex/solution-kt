class Solution {
  fun digitCount(num: String): Boolean {
    val cnt = IntArray(10)
    val n = num.length
    for (i in 0 until n) {
      ++cnt[num[i].code - '0'.code]
    }
    for (i in 0 until n) {
      if (cnt[i] != num[i].code - '0'.code) {
        return false
      }
    }
    return true
  }
}
