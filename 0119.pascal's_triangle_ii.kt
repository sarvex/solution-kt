internal class Solution {
  fun getRow(rowIndex: Int): List<Int> {
    val f: List<Int> = ArrayList()
    for (i in 0 until rowIndex + 1) {
      f.add(1)
    }
    for (i in 2 until rowIndex + 1) {
      for (j in i - 1 downTo 1) {
        f.set(j, f[j] + f[j - 1])
      }
    }
    return f
  }
}
