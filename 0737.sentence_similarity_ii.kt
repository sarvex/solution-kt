internal class Solution {
  private var p: IntArray
  fun areSentencesSimilarTwo(
    sentence1: Array<String?>, sentence2: Array<String?>, similarPairs: List<List<String?>>
  ): Boolean {
    if (sentence1.size != sentence2.size) {
      return false
    }
    val n: Int = similarPairs.size()
    p = IntArray(n shl 1)
    for (i in p.indices) {
      p[i] = i
    }
    val words: Map<String?, Int> = HashMap()
    var idx = 0
    for (e in similarPairs) {
      val a = e[0]
      val b = e[1]
      if (!words.containsKey(a)) {
        words.put(a, idx++)
      }
      if (!words.containsKey(b)) {
        words.put(b, idx++)
      }
      p[find(words[a]!!)] = find(words[b]!!)
    }
    for (i in sentence1.indices) {
      if (Objects.equals(sentence1[i], sentence2[i])) {
        continue
      }
      if (!words.containsKey(sentence1[i]) || !words.containsKey(sentence2[i]) || find(words[sentence1[i]]!!) != find(
          words[sentence2[i]]!!
        )
      ) {
        return false
      }
    }
    return true
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
