internal class Trie {
  private val children = arrayOfNulls<Trie>(26)
  private val ref = -1
  fun insert(w: String, i: Int) {
    var node = this
    for (j in 0 until w.length) {
      val idx = w[j].code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]!!
    }
    node.ref = i
  }

  fun search(w: String): Int {
    var node = this
    for (j in 0 until w.length) {
      val idx = w[j].code - 'a'.code
      if (node.children[idx] == null) {
        return -1
      }
      node = node.children[idx]!!
      if (node.ref != -1) {
        return node.ref
      }
    }
    return -1
  }
}

internal class Solution {
  fun replaceWords(dictionary: List<String?>, sentence: String): String {
    val trie = Trie()
    for (i in 0 until dictionary.size()) {
      trie.insert(dictionary[i]!!, i)
    }
    val ans: List<String> = ArrayList()
    for (w in sentence.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      val idx: Int = trie.search(w)
      ans.add(if (idx == -1) w else dictionary[idx])
    }
    return java.lang.String.join(" ", ans)
  }
}
