class Solution {
  fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
    var words1 = sentence1.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    var words2 = sentence2.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (words1.size < words2.size) {
      val t = words1
      words1 = words2
      words2 = t
    }
    val m = words1.size
    val n = words2.size
    var i = 0
    var j = 0
    while (i < n && words1[i] == words2[i]) {
      ++i
    }
    while (j < n && words1[m - 1 - j] == words2[n - 1 - j]) {
      ++j
    }
    return i + j >= n
  }
}
