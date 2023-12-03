internal class Solution {
  fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (p in paths) {
      val x = p[0] - 1
      val y = p[1] - 1
      g[x].add(y)
      g[y].add(x)
    }
    val ans = IntArray(n)
    val used = BooleanArray(5)
    for (x in 0 until n) {
      Arrays.fill(used, false)
      for (y in g[x]!!) {
        used[ans[y]] = true
      }
      for (c in 1..4) {
        if (!used[c]) {
          ans[x] = c
          break
        }
      }
    }
    return ans
  }
}
