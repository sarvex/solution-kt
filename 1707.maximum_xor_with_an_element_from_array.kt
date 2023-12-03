class Solution {
  fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
    val trie = Trie()
    Arrays.sort(nums)
    val n = queries.size
    val ans = IntArray(n)
    val qs = Array(n) { IntArray(3) }
    for (i in 0 until n) {
      qs[i] = intArrayOf(i, queries[i][0], queries[i][1])
    }
    Arrays.sort(qs) { a, b -> a.get(2) - b.get(2) }
    var j = 0
    for (q in qs) {
      val i = q[0]
      val x = q[1]
      val m = q[2]
      while (j < nums.size && nums[j] <= m) {
        trie.insert(nums[j++])
      }
      ans[i] = trie.search(x)
    }
    return ans
  }
}

internal class Trie {
  var children = arrayOfNulls<Trie>(2)
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
      } else if (node.children[v] != null) {
        node = node.children[v]
      } else {
        return -1
      }
    }
    return ans
  }
}
