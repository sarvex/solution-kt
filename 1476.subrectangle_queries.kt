class SubrectangleQueries(private val g: Array<IntArray>) {
  private val ops: LinkedList<IntArray> = LinkedList()
  fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
    ops.addFirst(intArrayOf(row1, col1, row2, col2, newValue))
  }

  fun getValue(row: Int, col: Int): Int {
    for (op in ops) {
      if (op.get(0) <= row && row <= op.get(2) && op.get(1) <= col && col <= op.get(3)) {
        return op.get(4)
      }
    }
    return g[row][col]
  }
}
