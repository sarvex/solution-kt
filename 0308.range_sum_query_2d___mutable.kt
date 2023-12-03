internal class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, delta: Int) {
    var x = x
    while (x <= n) {
      c[x] += delta
      x += lowbit(x)
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= lowbit(x)
    }
    return s
  }

  companion object {
    fun lowbit(x: Int): Int {
      return x and -x
    }
  }
}

internal class NumMatrix(matrix: Array<IntArray>) {
  private val trees: Array<BinaryIndexedTree?>

  init {
    val m = matrix.size
    val n = matrix[0].size
    trees = arrayOfNulls(m)
    for (i in 0 until m) {
      val tree = BinaryIndexedTree(n)
      for (j in 0 until n) {
        tree.update(j + 1, matrix[i][j])
      }
      trees[i] = tree
    }
  }

  fun update(row: Int, col: Int, `val`: Int) {
    val tree = trees[row]
    val prev = tree!!.query(col + 1) - tree.query(col)
    tree.update(col + 1, `val` - prev)
  }

  fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
    var s = 0
    for (i in row1..row2) {
      val tree = trees[i]
      s += tree!!.query(col2 + 1) - tree.query(col1)
    }
    return s
  }
}
