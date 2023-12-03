class Solution {
  fun sortString(s: String): String {
    val counter = IntArray(26)
    for (c in s.toCharArray()) {
      ++counter[c.code - 'a'.code]
    }
    val sb = StringBuilder()
    while (sb.length < s.length) {
      for (i in 0..25) {
        if (counter[i] > 0) {
          sb.append(('a'.code + i).toChar())
          --counter[i]
        }
      }
      for (i in 25 downTo 0) {
        if (counter[i] > 0) {
          sb.append(('a'.code + i).toChar())
          --counter[i]
        }
      }
    }
    return sb.toString()
  }
}
