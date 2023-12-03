class Solution {
  fun minMaxDifference(num: Int): Int {
    val s = num.toString()
    val mi = s.replace(s[0], '0').toInt()
    for (c in s.toCharArray()) {
      if (c != '9') {
        return s.replace(c, '9').toInt() - mi
      }
    }
    return num - mi
  }
}
