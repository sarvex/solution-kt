internal class Solution {
  fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
    var k = k
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var x = -100
    while (x < 0 && k > 0) {
      if (cnt[x] ?: 0 > 0) {
        val m = Math.min(cnt[x]!!, k)
        cnt.merge(x, -m) { a: Int, b: Int -> Integer.sum(a, b) }
        cnt.merge(-x, m) { a: Int, b: Int -> Integer.sum(a, b) }
        k -= m
      }
      ++x
    }
    if (k and 1 == 1 && cnt[0] ?: 0 === 0) {
      for (x in 1..100) {
        if (cnt[x] ?: 0 > 0) {
          cnt.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) }
          cnt.merge(-x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
          break
        }
      }
    }
    var ans = 0
    for (e in cnt.entrySet()) {
      ans += e.getKey() * e.getValue()
    }
    return ans
  }
}
