import kotlin.math.min

class Solution {
  fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var ans = 0
    for (i in tickets.indices) {
      if (i <= k) {
        (ans += min(tickets[k].toDouble(), tickets[i].toDouble())).toInt()
      } else {
        (ans += min((tickets[k] - 1).toDouble(), tickets[i].toDouble())).toInt()
      }
    }
    return ans
  }
}
