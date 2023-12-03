import kotlin.math.max

internal class Solution {
  fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
    var capacityA = capacityA
    var capacityB = capacityB
    var i = 0
    var j = plants.size - 1
    var ans = 0
    val a = capacityA
    val b = capacityB
    while (i <= j) {
      if (i == j) {
        if (max(capacityA.toDouble(), capacityB.toDouble()) < plants[i]) {
          ++ans
        }
        break
      }
      if (capacityA < plants[i]) {
        capacityA = a - plants[i]
        ++ans
      } else {
        capacityA -= plants[i]
      }
      if (capacityB < plants[j]) {
        capacityB = b - plants[j]
        ++ans
      } else {
        capacityB -= plants[j]
      }
      ++i
      --j
    }
    return ans
  }
}
