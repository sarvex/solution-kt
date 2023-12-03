internal class Solution {
  fun removeDuplicates(s: String): String {
    val sb = StringBuilder()
    for (c in s.toCharArray()) {
      if (sb.length > 0 && sb[sb.length - 1] == c) {
        sb.deleteCharAt(sb.length - 1)
      } else {
        sb.append(c)
      }
    }
    return sb.toString()
  }
}
