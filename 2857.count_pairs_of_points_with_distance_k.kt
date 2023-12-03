class Solution {
  fun countPairs(coordinates: List<List<Int?>>, k: Int): Int {
    val cnt: Map<List<Int>, Int> = HashMap()
    var ans = 0
    for (c in coordinates) {
      val x2: Int = c[0]
      val y2: Int = c[1]
      for (a in 0..k) {
        val b = k - a
        val x1 = a xor x2
        val y1 = b xor y2
        ans += cnt[List.of(x1, y1)] ?: 0
      }
      cnt.merge(c, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
