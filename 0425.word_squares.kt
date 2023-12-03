internal class Trie {
  var children = arrayOfNulls<Trie>(26)
  @JvmField
  var v: List<Int> = ArrayList()
  fun insert(word: String, i: Int) {
    var node = this
    for (c in word.toCharArray()) {
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]!!
      node.v.add(i)
    }
  }

  fun search(pref: String): List<Int> {
    var node = this
    for (c in pref.toCharArray()) {
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        return Collections.emptyList()
      }
      node = node.children[c.code]!!
    }
    return node.v
  }
}

internal class Solution {
  private val trie = Trie()
  private var words: Array<String>
  private val ans: List<List<String>> = ArrayList()
  fun wordSquares(words: Array<String>): List<List<String>> {
    this.words = words
    for (i in words.indices) {
      trie.insert(words[i], i)
    }
    val t: List<String> = ArrayList()
    for (w in words) {
      t.add(w)
      dfs(t)
      t.remove(t.size() - 1)
    }
    return ans
  }

  private fun dfs(t: List<String>) {
    if (t.size() === words[0].length) {
      ans.add(ArrayList(t))
      return
    }
    val idx: Int = t.size()
    val pref = StringBuilder()
    for (x in t) {
      pref.append(x[idx])
    }
    val indexes: List<Int> = trie.search(pref.toString())
    for (i in indexes) {
      t.add(words[i])
      dfs(t)
      t.remove(t.size() - 1)
    }
  }
}
