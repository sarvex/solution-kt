class Solution {
  fun detectCapitalUse(word: String): Boolean {
    var cnt = 0
    for (c in word.toCharArray()) {
      if (Character.isUpperCase(c)) {
        ++cnt
      }
    }
    return cnt == 0 || cnt == word.length || cnt == 1 && Character.isUpperCase(word[0])
  }
}
