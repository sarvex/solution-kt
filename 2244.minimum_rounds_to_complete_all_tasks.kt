class Solution {
  fun minimumRounds(tasks: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (t in tasks) {
      cnt.merge(t, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    for (v in cnt.values()) {
      if (v == 1) {
        return -1
      }
      ans += v / 3 + if (v % 3 == 0) 0 else 1
    }
    return ans
  }
}
