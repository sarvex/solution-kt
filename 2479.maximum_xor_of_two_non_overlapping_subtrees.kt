import kotlin.math.max

class Trie {
  var children = arrayOfNulls<Trie>(2)
  fun insert(x: Long) {
    var node = this
    for (i in 47 downTo 0) {
      val v = (x shr i).toInt() and 1
      if (node.children[v] == null) {
        node.children[v] = Trie()
      }
      node = node.children[v]!!
    }
  }

  fun search(x: Long): Long {
    var node: Trie? = this
    var res: Long = 0
    for (i in 47 downTo 0) {
      val v = (x shr i).toInt() and 1
      if (node == null) {
        return res
      }
      if (node.children[v xor 1] != null) {
        res = res shl 1 or 1L
        node = node.children[v xor 1]
      } else {
        res = res shl 1
        node = node.children[v]
      }
    }
    return res
  }
}

internal class Solution {
  private var g: Array<List<Int>?>
  private var vals: IntArray
  private var s: LongArray
  private var tree: Trie? = null
  private var ans: Long = 0
  fun maxXor(n: Int, edges: Array<IntArray>, values: IntArray): Long {
    g = arrayOfNulls(n)
    s = LongArray(n)
    vals = values
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs1(0, -1)
    tree = Trie()
    dfs2(0, -1)
    return ans
  }

  private fun dfs2(i: Int, fa: Int) {
    ans = max(ans.toDouble(), tree!!.search(s[i]).toDouble()).toLong()
    for (j in g[i]!!) {
      if (j != fa) {
        dfs2(j, i)
      }
    }
    tree!!.insert(s[i])
  }

  private fun dfs1(i: Int, fa: Int): Long {
    var t = vals[i].toLong()
    for (j in g[i]!!) {
      if (j != fa) {
        t += dfs1(j, i)
      }
    }
    s[i] = t
    return t
  }
}
