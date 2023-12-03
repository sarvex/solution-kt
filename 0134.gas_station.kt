internal class Solution {
  fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val n = gas.size
    var i = n - 1
    var j = n - 1
    var cnt = 0
    var s = 0
    while (cnt < n) {
      s += gas[j] - cost[j]
      ++cnt
      j = (j + 1) % n
      while (s < 0 && cnt < n) {
        --i
        s += gas[i] - cost[i]
        ++cnt
      }
    }
    return if (s < 0) -1 else i
  }
}
