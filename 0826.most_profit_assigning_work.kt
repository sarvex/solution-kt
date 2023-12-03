internal class Solution {
  fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    val n = difficulty.size
    val job: List<IntArray> = ArrayList()
    for (i in 0 until n) {
      job.add(intArrayOf(difficulty[i], profit[i]))
    }
    job.sort(Comparator.comparing { a -> a.get(0) })
    Arrays.sort(worker)
    var res = 0
    var i = 0
    var t = 0
    for (w in worker) {
      while (i < n && job[i][0] <= w) {
        t = Math.max(t, job[i++][1])
      }
      res += t
    }
    return res
  }
}
