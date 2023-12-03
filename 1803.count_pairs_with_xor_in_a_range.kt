class Trie {
  private val children = arrayOfNulls<Trie>(2)
  private val cnt = 0
  fun insert(x: Int) {
    var node = this
    for (i in 15 downTo 0) {
      val v = x shr i and 1
      if (node.children[v] == null) {
        node.children[v] = Trie()
      }
      node = node.children[v]!!
      ++node.cnt
    }
  }

  fun search(x: Int, limit: Int): Int {
    var node: Trie? = this
    var ans = 0
    var i = 15
    while (i >= 0 && node != null) {
      val v = x shr i and 1
      if (limit shr i and 1 == 1) {
        if (node.children[v] != null) {
          ans += node.children[v].cnt
        }
        node = node.children[v xor 1]
      } else {
        node = node.children[v]
      }
      --i
    }
    return ans
  }
}

internal class Solution {
  fun countPairs(nums: IntArray, low: Int, high: Int): Int {
    val trie = Trie()
    var ans = 0
    for (x in nums) {
      ans += trie.search(x, high + 1) - trie.search(x, low)
      trie.insert(x)
    }
    return ans
  }
}
