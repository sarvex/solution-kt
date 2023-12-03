internal class Solution {
  fun wordCount(startWords: Array<String>, targetWords: Array<String>): Int {
    val s: Set<Int> = HashSet()
    for (word in startWords) {
      var mask = 0
      for (c in word.toCharArray()) {
        mask = mask or (1 shl c.code - 'a'.code)
      }
      s.add(mask)
    }
    var ans = 0
    for (word in targetWords) {
      var mask = 0
      for (c in word.toCharArray()) {
        mask = mask or (1 shl c.code - 'a'.code)
      }
      for (c in word.toCharArray()) {
        val t = mask xor (1 shl c.code - 'a'.code)
        if (s.contains(t)) {
          ++ans
          break
        }
      }
    }
    return ans
  }
}
