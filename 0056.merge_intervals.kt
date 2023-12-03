internal class Solution {
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    Arrays.sort(intervals) { a, b -> a.get(0) - b.get(0) }
    val ans: List<IntArray> = ArrayList()
    ans.add(intervals[0])
    for (i in 1 until intervals.size) {
      val s = intervals[i][0]
      val e = intervals[i][1]
      if (ans[ans.size() - 1][1] < s) {
        ans.add(intervals[i])
      } else {
        ans[ans.size() - 1][1] = Math.max(ans[ans.size() - 1][1], e)
      }
    }
    return ans.toArray(arrayOfNulls<IntArray>(ans.size()))
  }
}
