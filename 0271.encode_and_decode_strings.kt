class Codec {
  // Encodes a list of strings to a single string.
  fun encode(strs: List<String>): String {
    val ans = StringBuilder()
    for (s in strs) {
      ans.append(s.length.toChar()).append(s)
    }
    return ans.toString()
  }

  // Decodes a single string to a list of strings.
  fun decode(s: String): List<String> {
    val ans: List<String> = ArrayList()
    var i = 0
    val n = s.length
    while (i < n) {
      val size = s[i++].code
      ans.add(s.substring(i, i + size))
      i += size
    }
    return ans
  }
}
