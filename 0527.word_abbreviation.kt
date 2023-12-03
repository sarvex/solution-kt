internal class Trie {
  private val children = arrayOfNulls<Trie>(26)
  private val cnt = 0
  fun insert(w: String) {
    var node = this
    for (c in w.toCharArray()) {
      val idx = c.code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]!!
      ++node.cnt
    }
  }

  fun search(w: String): Int {
    var node = this
    var ans = 0
    for (c in w.toCharArray()) {
      ++ans
      val idx = c.code - 'a'.code
      node = node.children[idx]!!
      if (node.cnt == 1) {
        return ans
      }
    }
    return w.length
  }
}

internal class Solution {
  fun wordsAbbreviation(words: List<String>): List<String> {
    val tries: Map<List<Int>, Trie> = HashMap()
    for (w in words) {
      val key: Unit = List.of(w.length(), w.charAt(w.length() - 1) - 'a')
      tries.putIfAbsent(key, Trie())
      tries.get(key)!!.insert(w)
    }
    val ans: List<String> = ArrayList()
    for (w in words) {
      val m: Int = w.length()
      val key: Unit = List.of(m, w.charAt(m - 1) - 'a')
      val cnt: Int = tries.get(key)!!.search(w)
      ans.add(if (cnt + 2 >= m) w else w.substring(0, cnt) + (m - cnt - 1) + w.substring(m - 1))
    }
    return ans
  }
}
