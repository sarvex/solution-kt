internal class WordDistance(wordsDict: Array<String?>) {
  private val d: Map<String, List<Int>> = HashMap()

  init {
    for (i in wordsDict.indices) {
      d.computeIfAbsent(wordsDict[i]) { k -> ArrayList() }.add(i)
    }
  }

  fun shortest(word1: String, word2: String): Int {
    val a = d[word1]!!
    val b = d[word2]!!
    var ans = 0x3f3f3f3f
    var i = 0
    var j = 0
    while (i < a.size() && j < b.size()) {
      ans = Math.min(ans, Math.abs(a[i] - b[j]))
      if (a[i] <= b[j]) {
        ++i
      } else {
        ++j
      }
    }
    return ans
  }
}
