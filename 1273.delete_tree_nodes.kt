internal class Solution {
  private var g: Array<List<Int>?>
  private var value: IntArray
  fun deleteTreeNodes(nodes: Int, parent: IntArray, value: IntArray): Int {
    g = arrayOfNulls(nodes)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 1 until nodes) {
      g[parent[i]].add(i)
    }
    this.value = value
    return dfs(0)[1]
  }

  private fun dfs(i: Int): IntArray {
    val res = intArrayOf(value[i], 1)
    for (j in g[i]!!) {
      val t = dfs(j)
      res[0] += t[0]
      res[1] += t[1]
    }
    if (res[0] == 0) {
      res[1] = 0
    }
    return res
  }
}
