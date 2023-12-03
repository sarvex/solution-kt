class Solution {
  private var p: IntArray
  fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    var n = n
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    val vis = BooleanArray(n)
    var i = 0
    val m = n
    while (i < m) {
      for (j in intArrayOf(leftChild[i], rightChild[i])) {
        if (j != -1) {
          if (vis[j] || find(i) == find(j)) {
            return false
          }
          p[find(i)] = find(j)
          vis[j] = true
          --n
        }
      }
      ++i
    }
    return n == 1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
