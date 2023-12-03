class Solution {
  fun minimumIndex(nums: List<Int>): Int {
    var x = 0
    var cnt = 0
    val freq: Map<Int, Int> = HashMap()
    for (v in nums) {
      val t: Int = freq.merge(v, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt < t) {
        cnt = t
        x = v
      }
    }
    var cur = 0
    for (i in 1..nums.size()) {
      if (nums[i - 1] === x) {
        ++cur
        if (cur * 2 > i && (cnt - cur) * 2 > nums.size() - i) {
          return i - 1
        }
      }
    }
    return -1
  }
}
