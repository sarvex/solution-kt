internal class Solution {
  fun reverseVowels(s: String): String {
    val vowels = BooleanArray(128)
    for (c in "aeiouAEIOU".toCharArray()) {
      vowels[c.code] = true
    }
    val cs = s.toCharArray()
    var i = 0
    var j = cs.size - 1
    while (i < j) {
      while (i < j && !vowels[cs[i].code]) {
        ++i
      }
      while (i < j && !vowels[cs[j].code]) {
        --j
      }
      if (i < j) {
        val t = cs[i]
        cs[i] = cs[j]
        cs[j] = t
        ++i
        --j
      }
    }
    return String(cs)
  }
}
