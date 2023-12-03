internal class Solution {
  fun numFriendRequests(ages: IntArray): Int {
    val counter = IntArray(121)
    for (age in ages) {
      ++counter[age]
    }
    var ans = 0
    for (i in 1..120) {
      val n1 = counter[i]
      for (j in 1..120) {
        val n2 = counter[j]
        if (!(j <= 0.5 * i + 7 || j > i || j > 100 && i < 100)) {
          ans += n1 * n2
          if (i == j) {
            ans -= n2
          }
        }
      }
    }
    return ans
  }
}
