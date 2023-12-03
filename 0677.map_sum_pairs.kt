internal class Trie {
  private val children = arrayOfNulls<Trie>(26)
  private val `val` = 0
  fun insert(w: String, x: Int) {
    var node = this
    for (i in 0 until w.length) {
      val idx = w[i].code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]!!
      node.`val` += x
    }
  }

  fun search(w: String): Int {
    var node = this
    for (i in 0 until w.length) {
      val idx = w[i].code - 'a'.code
      if (node.children[idx] == null) {
        return 0
      }
      node = node.children[idx]!!
    }
    return node.`val`
  }
}

internal class MapSum {
  private val d: Map<String, Int> = HashMap()
  private val trie = Trie()
  fun insert(key: String, `val`: Int) {
    val x = `val` - (d[key] ?: 0)
    d.put(key, `val`)
    trie.insert(key, x)
  }

  fun sum(prefix: String?): Int {
    return trie.search(prefix!!)
  }
}
