class Solution {
  fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val n = groupSizes.size
    val g: Array<List<Int>?> = arrayOfNulls(n + 1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      g[groupSizes[i]].add(i)
    }
    val ans: List<List<Int>> = ArrayList()
    for (i in g.indices) {
      val v = g[i]
      var j = 0
      while (j < v!!.size()) {
        ans.add(v!!.subList(j, j + i))
        j += i
      }
    }
    return ans
  }
}
