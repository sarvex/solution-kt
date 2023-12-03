class Solution {
  fun maximumOddBinaryNumber(s: String): String {
    var cnt = 0
    for (c in s.toCharArray()) {
      if (c == '1') {
        ++cnt
      }
    }
    return "1".repeat(cnt - 1) + "0".repeat(s.length - cnt) + "1"
  }
}
