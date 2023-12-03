internal class Trie {
  @JvmField
  var children = arrayOfNulls<Trie>(26)
  @JvmField
  var isEnd = false
  fun insert(w: String) {
    var node = this
    for (c in w.toCharArray()) {
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]!!
    }
    node.isEnd = true
  }
}

internal class Solution {
  private val trie = Trie()
  fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
    Arrays.sort(words) { a, b -> a.length() - b.length() }
    val ans: List<String> = ArrayList()
    for (w in words) {
      if (dfs(w)) {
        ans.add(w)
      } else {
        trie.insert(w)
      }
    }
    return ans
  }

  private fun dfs(w: String): Boolean {
    if ("" == w) {
      return true
    }
    var node = trie
    for (i in 0 until w.length) {
      val idx = w[i].code - 'a'.code
      if (node.children[idx] == null) {
        return false
      }
      node = node.children[idx]!!
      if (node.isEnd && dfs(w.substring(i + 1))) {
        return true
      }
    }
    return false
  }
}
