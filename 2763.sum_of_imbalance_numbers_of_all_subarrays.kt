class Solution {
  fun sumImbalanceNumbers(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      val tm: TreeMap<Int, Int> = TreeMap()
      var cnt = 0
      for (j in i until n) {
        val k: Int = tm.ceilingKey(nums[j])
        if (k != null && k - nums[j] > 1) {
          ++cnt
        }
        val h: Int = tm.floorKey(nums[j])
        if (h != null && nums[j] - h > 1) {
          ++cnt
        }
        if (h != null && k != null && k - h > 1) {
          --cnt
        }
        tm.merge(nums[j], 1) { a: Int, b: Int -> Integer.sum(a, b) }
        ans += cnt
      }
    }
    return ans
  }
}
