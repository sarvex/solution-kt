class Solution {
  fun isItPossible(word1: String, word2: String): Boolean {
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until word1.length) {
      ++cnt1[word1[i].code - 'a'.code]
    }
    for (i in 0 until word2.length) {
      ++cnt2[word2[i].code - 'a'.code]
    }
    for (i in 0..25) {
      for (j in 0..25) {
        if (cnt1[i] > 0 && cnt2[j] > 0) {
          --cnt1[i]
          --cnt2[j]
          ++cnt1[j]
          ++cnt2[i]
          var d = 0
          for (k in 0..25) {
            if (cnt1[k] > 0) {
              ++d
            }
            if (cnt2[k] > 0) {
              --d
            }
          }
          if (d == 0) {
            return true
          }
          ++cnt1[i]
          ++cnt2[j]
          --cnt1[j]
          --cnt2[i]
        }
      }
    }
    return false
  }
}
