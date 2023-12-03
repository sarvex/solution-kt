class Solution {
  fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    Arrays.sort(potions)
    val n = spells.size
    val m = potions.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      var left = 0
      var right = m
      while (left < right) {
        val mid = left + right shr 1
        if (spells[i].toLong() * potions[mid] >= success) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      ans[i] = m - left
    }
    return ans
  }
}
