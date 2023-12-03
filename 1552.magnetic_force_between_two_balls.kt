class Solution {
  fun maxDistance(position: IntArray, m: Int): Int {
    Arrays.sort(position)
    var left = 1
    var right = position[position.size - 1]
    while (left < right) {
      val mid = left + right + 1 ushr 1
      if (check(position, mid, m)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(position: IntArray, f: Int, m: Int): Boolean {
    var prev = position[0]
    var cnt = 1
    for (i in 1 until position.size) {
      val curr = position[i]
      if (curr - prev >= f) {
        prev = curr
        ++cnt
      }
    }
    return cnt >= m
  }
}
