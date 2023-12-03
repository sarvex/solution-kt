 class Trie {
  @JvmField
  var children = arrayOfNulls<Trie>(26)
  @JvmField
  var isEnd = false
  fun insert(word: String) {
    var node: Trie? = this
    for (c in word.toCharArray()) {
      (c -= 'a').toChar()
      if (node!!.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]
    }
    node!!.isEnd = true
  }

  fun search(word: String): Boolean {
    var node: Trie? = this
    for (c in word.toCharArray()) {
      (c -= 'a').toChar()
      if (node!!.children[c.code] == null) {
        return false
      }
      node = node.children[c.code]
    }
    return node!!.isEnd
  }
}

internal class Solution {
  private val trie = Trie()
  fun wordBreak(s: String, wordDict: List<String>): List<String> {
    for (w in wordDict) {
      trie.insert(w)
    }
    val res = dfs(s)
    return res.stream().map { e -> java.lang.String.join(" ", e) }.collect(Collectors.toList())
  }

  private fun dfs(s: String): List<List<String>> {
    val res: List<List<String>> = ArrayList()
    if ("" == s) {
      res.add(ArrayList())
      return res
    }
    for (i in 1..s.length) {
      if (trie.search(s.substring(0, i))) {
        for (v in dfs(s.substring(i))) {
          v.add(0, s.substring(0, i))
          res.add(v)
        }
      }
    }
    return res
  }
}
