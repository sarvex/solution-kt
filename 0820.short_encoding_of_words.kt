internal class Trie {
  @JvmField
  var children = arrayOfNulls<Trie>(26)
}

internal class Solution {
  fun minimumLengthEncoding(words: Array<String>): Int {
    val root = Trie()
    for (w in words) {
      var cur = root
      for (i in w.length - 1 downTo 0) {
        val idx = w[i].code - 'a'.code
        if (cur.children[idx] == null) {
          cur.children[idx] = Trie()
        }
        cur = cur.children[idx]!!
      }
    }
    return dfs(root, 1)
  }

  private fun dfs(cur: Trie, l: Int): Int {
    var isLeaf = true
    var ans = 0
    for (i in 0..25) {
      if (cur.children[i] != null) {
        isLeaf = false
        ans += dfs(cur.children[i]!!, l + 1)
      }
    }
    if (isLeaf) {
      ans += l
    }
    return ans
  }
}
