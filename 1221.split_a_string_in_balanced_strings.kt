class Solution {
  fun balancedStringSplit(s: String): Int {
    var ans = 0
    var l = 0
    for (c in s.toCharArray()) {
      if (c == 'L') {
        ++l
      } else {
        --l
      }
      if (l == 0) {
        ++ans
      }
    }
    return ans
  }
}
