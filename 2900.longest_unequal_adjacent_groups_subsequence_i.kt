class Solution {
  fun getWordsInLongestSubsequence(n: Int, words: Array<String?>, groups: IntArray): List<String> {
    val ans: List<String> = ArrayList()
    for (i in 0 until n) {
      if (i == 0 || groups[i] != groups[i - 1]) {
        ans.add(words[i])
      }
    }
    return ans
  }
}
