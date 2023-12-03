internal class Solution {
  fun canPermutePalindrome(s: String): Boolean {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    var odd = 0
    for (x in cnt) {
      odd += x and 1
    }
    return odd < 2
  }
}
