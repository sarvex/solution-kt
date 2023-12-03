internal class Solution {
  fun areNumbersAscending(s: String): Boolean {
    var pre = 0
    for (t in s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      if (t[0] <= '9') {
        val cur = t.toInt()
        if (pre >= cur) {
          return false
        }
        pre = cur
      }
    }
    return true
  }
}
