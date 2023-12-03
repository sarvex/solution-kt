internal class Solution {
  fun highFive(items: Array<IntArray>): Array<IntArray> {
    val d: Array<List<Int>?> = arrayOfNulls(1001)
    Arrays.setAll(d) { k -> ArrayList() }
    for (item in items) {
      val i = item[0]
      val x = item[1]
      d[i].add(x)
    }
    for (xs in d) {
      xs.sort { a, b -> b - a }
    }
    val ans: List<IntArray> = ArrayList()
    for (i in 1..1000) {
      val xs = d[i]
      if (!xs!!.isEmpty()) {
        var s = 0
        for (j in 0..4) {
          s += xs[j]
        }
        ans.add(intArrayOf(i, s / 5))
      }
    }
    return ans.toArray(arrayOfNulls<IntArray>(0))
  }
}
