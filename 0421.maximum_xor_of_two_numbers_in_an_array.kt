import kotlin.math.max

internal class Trie {
  private val children = arrayOfNulls<Trie>(2)
  fun insert(x: Int) {
    var node = this
    for (i in 30 downTo 0) {
      val v = x shr i and 1
      if (node.children[v] == null) {
        node.children[v] = Trie()
      }
      node = node.children[v]!!
    }
  }

  fun search(x: Int): Int {
    var node = this
    var ans = 0
    for (i in 30 downTo 0) {
      val v = x shr i and 1
      if (node.children[v xor 1] != null) {
        ans = ans or (1 shl i)
        node = node.children[v xor 1]!!
      } else {
        node = node.children[v]!!
      }
    }
    return ans
  }
}

internal class Solution {
  fun findMaximumXOR(nums: IntArray): Int {
    val trie = Trie()
    var ans = 0
    for (x in nums) {
      trie.insert(x)
      ans = max(ans.toDouble(), trie.search(x).toDouble()).toInt()
    }
    return ans
  }
}
