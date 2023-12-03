internal class Solution {
  fun countWords(words1: Array<String>, words2: Array<String>): Int {
    val cnt1 = count(words1)
    val cnt2 = count(words2)
    var ans = 0
    for (w in words1) {
      if (cnt1[w] ?: 0 === 1 && cnt2[w] ?: 0 === 1) {
        ++ans
      }
    }
    return ans
  }

  private fun count(words: Array<String>): Map<String, Int> {
    val cnt: Map<String, Int> = HashMap()
    for (w in words) {
      cnt.put(w, (cnt[w] ?: 0) + 1)
    }
    return cnt
  }
}
