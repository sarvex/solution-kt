class Solution {
  fun minMovesToMakePalindrome(s: String): Int {
    val n = s.length
    var ans = 0
    val cs = s.toCharArray()
    var i = 0
    var j = n - 1
    while (i < j) {
      var even = false
      var k = j
      while (k != i) {
        if (cs[i] == cs[k]) {
          even = true
          while (k < j) {
            val t = cs[k]
            cs[k] = cs[k + 1]
            cs[k + 1] = t
            ++ans
            ++k
          }
          --j
          break
        }
        --k
      }
      if (!even) {
        ans += n / 2 - i
      }
      ++i
    }
    return ans
  }
}
