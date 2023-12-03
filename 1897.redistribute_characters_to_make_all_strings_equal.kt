class Solution {
  fun makeEqual(words: Array<String>): Boolean {
    val counter = IntArray(26)
    for (word in words) {
      for (c in word.toCharArray()) {
        ++counter[c.code - 'a'.code]
      }
    }
    val n = words.size
    for (i in 0..25) {
      if (counter[i] % n != 0) {
        return false
      }
    }
    return true
  }
}
