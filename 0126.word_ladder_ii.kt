internal class Solution {
  private var ans: List<List<String>>? = null
  private var prev: Map<String, Set<String>>? = null
  fun findLadders(beginWord: String, endWord: String, wordList: List<String?>?): List<List<String>> {
    ans = ArrayList()
    val words: Set<String> = HashSet(wordList)
    if (!words.contains(endWord)) {
      return ans
    }
    words.remove(beginWord)
    val dist: Map<String, Int> = HashMap()
    dist.put(beginWord, 0)
    prev = HashMap()
    val q: Queue<String> = ArrayDeque()
    q.offer(beginWord)
    var found = false
    var step = 0
    while (!q.isEmpty() && !found) {
      ++step
      for (i in q.size() downTo 1) {
        val p: String = q.poll()
        val chars = p.toCharArray()
        for (j in chars.indices) {
          val ch = chars[j]
          var k = 'a'
          while (k <= 'z') {
            chars[j] = k
            val t = String(chars)
            if (dist[t] ?: 0 === step) {
              prev.get(t).add(p)
            }
            if (!words.contains(t)) {
              ++k
              continue
            }
            prev.computeIfAbsent(t) { key -> HashSet() }.add(p)
            words.remove(t)
            q.offer(t)
            dist.put(t, step)
            if (endWord == t) {
              found = true
            }
            ++k
          }
          chars[j] = ch
        }
      }
    }
    if (found) {
      val path: Deque<String> = ArrayDeque()
      path.add(endWord)
      dfs(path, beginWord, endWord)
    }
    return ans
  }

  private fun dfs(path: Deque<String>, beginWord: String, cur: String) {
    if (cur == beginWord) {
      ans.add(ArrayList(path))
      return
    }
    for (precursor in prev!![cur]!!) {
      path.addFirst(precursor)
      dfs(path, beginWord, precursor)
      path.removeFirst()
    }
  }
}
