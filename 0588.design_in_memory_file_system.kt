internal class Trie {
  var name: String? = null
  var isFile = false
  var content = StringBuilder()
  var children: Map<String, Trie> = HashMap()
  fun insert(path: String, isFile: Boolean): Trie {
    var node = this
    val ps = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        node.children.put(p, Trie())
      }
      node = node.children[p]!!
    }
    node.isFile = isFile
    if (isFile) {
      node.name = ps[ps.size - 1]
    }
    return node
  }

  fun search(path: String): Trie? {
    var node = this
    val ps = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        return null
      }
      node = node.children[p]!!
    }
    return node
  }
}

internal class FileSystem {
  private val root = Trie()
  fun ls(path: String?): List<String> {
    val ans: List<String> = ArrayList()
    val node = root.search(path!!) ?: return ans
    if (node.isFile) {
      ans.add(node.name)
      return ans
    }
    for (v in node.children.keySet()) {
      ans.add(v)
    }
    Collections.sort(ans)
    return ans
  }

  fun mkdir(path: String?) {
    root.insert(path!!, false)
  }

  fun addContentToFile(filePath: String?, content: String?) {
    val node: Trie = root.insert(filePath!!, true)
    node.content.append(content)
  }

  fun readContentFromFile(filePath: String?): String {
    val node: Trie = root.search(filePath!!)
    return node.content.toString()
  }
}
