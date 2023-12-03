internal class Trie(var v: Int) {
  var children: Map<String, Trie> = HashMap()
  fun insert(w: String, v: Int): Boolean {
    var node = this
    val ps = w.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size - 1) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        return false
      }
      node = node.children[p]!!
    }
    if (node.children.containsKey(ps[ps.size - 1])) {
      return false
    }
    node.children.put(ps[ps.size - 1], Trie(v))
    return true
  }

  fun search(w: String): Int {
    var node = this
    val ps = w.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        return -1
      }
      node = node.children[p]!!
    }
    return node.v
  }
}

internal class FileSystem {
  private val trie = Trie(-1)
  fun createPath(path: String?, value: Int): Boolean {
    return trie.insert(path!!, value)
  }

  operator fun get(path: String?): Int {
    return trie.search(path!!)
  }
}
