class TreeAncestor(n: Int, parent: IntArray) {
  private val p: Array<IntArray>

  init {
    p = Array(n) { IntArray(18) }
    for (e in p) {
      Arrays.fill(e, -1)
    }
    for (i in 0 until n) {
      p[i][0] = parent[i]
    }
    for (i in 0 until n) {
      for (j in 1..17) {
        if (p[i][j - 1] == -1) {
          continue
        }
        p[i][j] = p[p[i][j - 1]][j - 1]
      }
    }
  }

  fun getKthAncestor(node: Int, k: Int): Int {
    var node = node
    for (i in 17 downTo 0) {
      if (k shr i and 1 == 1) {
        node = p[node][i]
        if (node == -1) {
          break
        }
      }
    }
    return node
  }
}
