class Solution {
  fun maximumNumber(num: String, change: IntArray): String {
    val s = num.toCharArray()
    var i = 0
    while (i < s.size) {
      if (change[s[i].code - '0'.code] > s[i].code - '0'.code) {
        while (i < s.size && s[i].code - '0'.code <= change[s[i].code - '0'.code]) {
          s[i] = (change[s[i].code - '0'.code] + '0'.code).toChar()
          ++i
        }
        break
      }
      ++i
    }
    return String(s)
  }
}
