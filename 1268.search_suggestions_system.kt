internal class Trie {
  var children = arrayOfNulls<Trie>(26)
  var v: List<Int> = ArrayList()
  fun insert(w: String, i: Int) {
    var node = this
    for (j in 0 until w.length) {
      val idx = w[j].code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]!!
      if (node.v.size() < 3) {
        node.v.add(i)
      }
    }
  }

  fun search(w: String): Array<List<Int>?> {
    var node = this
    val n = w.length
    val ans: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(ans) { k -> ArrayList() }
    for (i in 0 until n) {
      val idx = w[i].code - 'a'.code
      if (node.children[idx] == null) {
        break
      }
      node = node.children[idx]!!
      ans[i] = node.v
    }
    return ans
  }
}

internal class Solution {
  fun suggestedProducts(products: Array<String?>, searchWord: String?): List<List<String>> {
    Arrays.sort(products)
    val trie = Trie()
    for (i in products.indices) {
      trie.insert(products[i]!!, i)
    }
    val ans: List<List<String>> = ArrayList()
    for (v in trie.search(searchWord!!)) {
      val t: List<String> = ArrayList()
      for (i in v) {
        t.add(products[i])
      }
      ans.add(t)
    }
    return ans
  }
}
