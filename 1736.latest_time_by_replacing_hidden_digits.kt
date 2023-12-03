class Solution {
  fun maximumTime(time: String): String {
    val t = time.toCharArray()
    if (t[0] == '?') {
      t[0] = if (t[1] >= '4' && t[1] <= '9') '1' else '2'
    }
    if (t[1] == '?') {
      t[1] = if (t[0] == '2') '3' else '9'
    }
    if (t[3] == '?') {
      t[3] = '5'
    }
    if (t[4] == '?') {
      t[4] = '9'
    }
    return String(t)
  }
}
