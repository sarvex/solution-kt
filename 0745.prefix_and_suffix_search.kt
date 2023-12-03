internal class Trie {
  var children = arrayOfNulls<Trie>(26)
  var indexes: List<Int> = ArrayList()
  fun insert(word: String, i: Int) {
    var node = this
    for (c in word.toCharArray()) {
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]!!
      node.indexes.add(i)
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
    return node.indexes
  }
}

internal class WordFilter(words: Array<String?>) {
  private val p = Trie()
  private val s = Trie()

  init {
    for (i in words.indices) {
      val w = words[i]
      p.insert(w!!, i)
      s.insert(StringBuilder(w).reverse().toString(), i)
    }
  }

  fun f(pref: String?, suff: String?): Int {
    var suff = suff
    suff = StringBuilder(suff).reverse().toString()
    val a: List<Int> = p.search(pref!!)
    val b: List<Int> = s.search(suff)
    if (a.isEmpty() || b.isEmpty()) {
      return -1
    }
    var i: Int = a.size() - 1
    var j: Int = b.size() - 1
    while (i >= 0 && j >= 0) {
      val c = a[i]
      val d = b[j]
      if (c == d) {
        return c
      }
      if (c > d) {
        --i
      } else {
        --j
      }
    }
    return -1
  }
}
