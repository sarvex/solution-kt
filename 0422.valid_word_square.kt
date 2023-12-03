internal class Solution {
  fun validWordSquare(words: List<String>): Boolean {
    val m: Int = words.size()
    for (i in 0 until m) {
      val n: Int = words[i].length()
      for (j in 0 until n) {
        if (j >= m || i >= words[j].length()) {
          return false
        }
        if (words[i].charAt(j) !== words[j].charAt(i)) {
          return false
        }
      }
    }
    return true
  }
}
