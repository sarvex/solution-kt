internal class Trie {
  private val children: Array<Trie?>
  private val isEnd = false

  init {
    children = arrayOfNulls(26)
  }

  fun insert(word: String) {
    var node = this
    for (c in word.toCharArray()) {
      val idx = c.code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]!!
    }
    node.isEnd = true
  }

  fun search(word: String): Boolean {
    val node = searchPrefix(word)
    return node != null && node.isEnd
  }

  fun startsWith(prefix: String): Boolean {
    val node = searchPrefix(prefix)
    return node != null
  }

  private fun searchPrefix(s: String): Trie? {
    var node = this
    for (c in s.toCharArray()) {
      val idx = c.code - 'a'.code
      if (node.children[idx] == null) {
        return null
      }
      node = node.children[idx]!!
    }
    return node
  }
}
