class Solution {
  fun breakPalindrome(palindrome: String): String {
    val n = palindrome.length
    if (n == 1) {
      return ""
    }
    val cs = palindrome.toCharArray()
    var i = 0
    while (i < n / 2 && cs[i] == 'a') {
      ++i
    }
    if (i == n / 2) {
      cs[n - 1] = 'b'
    } else {
      cs[i] = 'a'
    }
    return String(cs)
  }
}
