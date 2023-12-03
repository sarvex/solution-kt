internal class Solution {
  fun strStr(haystack: String, needle: String): Int {
    if ("" == needle) {
      return 0
    }
    val len1 = haystack.length
    val len2 = needle.length
    var p = 0
    var q = 0
    while (p < len1) {
      if (haystack[p] == needle[q]) {
        if (len2 == 1) {
          return p
        }
        ++p
        ++q
      } else {
        p -= q - 1
        q = 0
      }
      if (q == len2) {
        return p - q
      }
    }
    return -1
  }
}
