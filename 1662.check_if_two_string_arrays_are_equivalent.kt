class Solution {
  fun arrayStringsAreEqual(word1: Array<String?>, word2: Array<String?>): Boolean {
    return java.lang.String.join("", *word1) == java.lang.String.join("", *word2)
  }
}
