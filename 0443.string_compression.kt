internal class Solution {
  fun compress(chars: CharArray): Int {
    var k = 0
    val n = chars.size
    var i = 0
    var j = i + 1
    while (i < n) {
      while (j < n && chars[j] == chars[i]) {
        ++j
      }
      chars[k++] = chars[i]
      if (j - i > 1) {
        val cnt = (j - i).toString()
        for (c in cnt.toCharArray()) {
          chars[k++] = c
        }
      }
      i = j
    }
    return k
  }
}
