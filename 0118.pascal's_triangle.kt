internal class Solution {
  fun generate(numRows: Int): List<List<Int>> {
    val f: List<List<Int>> = ArrayList()
    f.add(List.of(1))
    for (i in 0 until numRows - 1) {
      val g: List<Int> = ArrayList()
      g.add(1)
      for (j in 0 until f[i].size() - 1) {
        g.add(f[i][j] + f[i][j + 1])
      }
      g.add(1)
      f.add(g)
    }
    return f
  }
}
