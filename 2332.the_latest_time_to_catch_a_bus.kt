class Solution {
  fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
    Arrays.sort(buses)
    Arrays.sort(passengers)
    var j = 0
    var c = 0
    for (t in buses) {
      c = capacity
      while (c > 0 && j < passengers.size && passengers[j] <= t) {
        --c
        ++j
      }
    }
    --j
    var ans = if (c > 0) buses[buses.size - 1] else passengers[j]
    while (j >= 0 && ans == passengers[j]) {
      --ans
      --j
    }
    return ans
  }
}
