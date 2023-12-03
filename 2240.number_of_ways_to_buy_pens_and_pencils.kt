class Solution {
  fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
    var ans: Long = 0
    for (x in 0..total / cost1) {
      val y = (total - x * cost1) / cost2 + 1
      ans += y.toLong()
    }
    return ans
  }
}
