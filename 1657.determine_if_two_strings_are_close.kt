class Solution {
  fun closeStrings(word1: String, word2: String): Boolean {
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until word1.length) {
      ++cnt1[word1[i].code - 'a'.code]
    }
    for (i in 0 until word2.length) {
      ++cnt2[word2[i].code - 'a'.code]
    }
    for (i in 0..25) {
      if (cnt1[i] > 0 && cnt2[i] == 0 || cnt2[i] > 0 && cnt1[i] == 0) {
        return false
      }
    }
    Arrays.sort(cnt1)
    Arrays.sort(cnt2)
    for (i in 0..25) {
      if (cnt1[i] != cnt2[i]) {
        return false
      }
    }
    return true
  }
}
