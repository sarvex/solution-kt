internal class Solution {
  fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val ans = IntArray(n)
    for (e in bookings) {
      val first = e[0]
      val last = e[1]
      val seats = e[2]
      ans[first - 1] += seats
      if (last < n) {
        ans[last] -= seats
      }
    }
    for (i in 1 until n) {
      ans[i] += ans[i - 1]
    }
    return ans
  }
}
