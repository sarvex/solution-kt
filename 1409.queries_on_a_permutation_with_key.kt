class Solution {
  fun processQueries(queries: IntArray, m: Int): IntArray {
    val p: List<Int> = LinkedList()
    for (i in 1..m) {
      p.add(i)
    }
    val ans = IntArray(queries.size)
    var i = 0
    for (v in queries) {
      val j = p.indexOf(v)
      ans[i++] = j
      p.remove(j)
      p.add(0, v)
    }
    return ans
  }
}
