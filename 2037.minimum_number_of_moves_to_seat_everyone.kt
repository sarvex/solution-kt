import kotlin.math.abs

class Solution {
  fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    Arrays.sort(seats)
    Arrays.sort(students)
    var ans = 0
    for (i in seats.indices) {
      (ans += abs((seats[i] - students[i]).toDouble())).toInt()
    }
    return ans
  }
}
