class Solution {
  fun mostFrequentEven(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      if (x % 2 == 0) {
        cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    var ans = -1
    var mx = 0
    for (e in cnt.entrySet()) {
      val x: Int = e.getKey()
      val v: Int = e.getValue()
      if (mx < v || mx == v && ans > x) {
        ans = x
        mx = v
      }
    }
    return ans
  }
}
