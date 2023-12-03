internal class Solution {
  fun minAddToMakeValid(s: String): Int {
    var ans = 0
    var cnt = 0
    for (c in s.toCharArray()) {
      if (c == '(') {
        ++cnt
      } else if (cnt > 0) {
        --cnt
      } else {
        ++ans
      }
    }
    ans += cnt
    return ans
  }
}
