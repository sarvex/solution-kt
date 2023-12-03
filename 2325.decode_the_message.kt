class Solution {
  fun decodeMessage(key: String, message: String): String {
    val d = CharArray(128)
    d[' '.code] = ' '
    run {
      var i = 0
      var j = 0
      while (i < key.length) {
        val c = key[i]
        if (d[c.code].code == 0) {
          d[c.code] = ('a'.code + j++).toChar()
        }
        ++i
      }
    }
    val ans = message.toCharArray()
    for (i in ans.indices) {
      ans[i] = d[ans[i].code]
    }
    return String(ans)
  }
}
