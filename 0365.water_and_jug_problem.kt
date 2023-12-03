internal class Solution {
  fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
    if (jug1Capacity + jug2Capacity < targetCapacity) {
      return false
    }
    return if (jug1Capacity == 0 || jug2Capacity == 0) {
      targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity
    } else targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
