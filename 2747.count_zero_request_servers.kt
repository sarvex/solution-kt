class Solution {
  fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
    Arrays.sort(logs) { a, b -> a.get(1) - b.get(1) }
    val m = queries.size
    val qs = Array(m) { IntArray(0) }
    for (i in 0 until m) {
      qs[i] = intArrayOf(queries[i], i)
    }
    Arrays.sort(qs) { a, b -> a.get(0) - b.get(0) }
    val cnt: Map<Int, Int> = HashMap()
    val ans = IntArray(m)
    var j = 0
    var k = 0
    for (q in qs) {
      val r = q[0]
      val i = q[1]
      val l = r - x
      while (k < logs.size && logs[k][1] <= r) {
        cnt.merge(logs[k++][0], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
      while (j < logs.size && logs[j][1] < l) {
        if (cnt.merge(logs[j][0], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          cnt.remove(logs[j][0])
        }
        j++
      }
      ans[i] = n - cnt.size()
    }
    return ans
  }
}
