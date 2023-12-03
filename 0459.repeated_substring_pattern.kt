internal class Solution {
  fun repeatedSubstringPattern(s: String): Boolean {
    val str = s + s
    return str.substring(1, str.length - 1).contains(s)
  }
}
