class Trie {
  var children = arrayOfNulls<Trie>(26)
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

  fun search(w: String): Boolean {
    var node = this
    for (c in w.toCharArray()) {
      (c -= 'a').toChar()
      node = node.children[c.code]!!
      if (!node.isEnd) {
        return false
      }
    }
    return true
  }
}

internal class Solution {
  fun longestWord(words: Array<String>): String {
    val trie = Trie()
    for (w in words) {
      trie.insert(w)
    }
    var ans = ""
    for (w in words) {
      if ("" != ans
        && (ans.length > w.length || ans.length == w.length && ans.compareTo(w) < 0)
      ) {
        continue
      }
      if (trie.search(w)) {
        ans = w
      }
    }
    return ans
  }
}
