internal class Vector2D(private val vec: Array<IntArray>) {
  private var i = 0
  private var j = 0
  operator fun next(): Int {
    forward()
    return vec[i][j++]
  }

  operator fun hasNext(): Boolean {
    forward()
    return i < vec.size
  }

  private fun forward() {
    while (i < vec.size && j >= vec[i].size) {
      ++i
      j = 0
    }
  }
}
