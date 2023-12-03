class Solution {
  fun maxValue(n: String, x: Int): String {
    var i = 0
    if (n[0] != '-') {
      while (i < n.length && n[i].code - '0'.code >= x) {
        ++i
      }
    } else {
      i = 1
      while (i < n.length && n[i].code - '0'.code <= x) {
        ++i
      }
    }
    return n.substring(0, i) + x + n.substring(i)
  }
}
