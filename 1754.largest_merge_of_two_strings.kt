class Solution {
  fun largestMerge(word1: String, word2: String): String {
    val m = word1.length
    val n = word2.length
    var i = 0
    var j = 0
    val ans = StringBuilder()
    while (i < m && j < n) {
      val gt = word1.substring(i).compareTo(word2.substring(j)) > 0
      ans.append(if (gt) word1[i++] else word2[j++])
    }
    ans.append(word1.substring(i))
    ans.append(word2.substring(j))
    return ans.toString()
  }
}
