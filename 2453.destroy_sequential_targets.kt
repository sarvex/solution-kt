class Solution {
  fun destroyTargets(nums: IntArray, space: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (v in nums) {
      v %= space
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
    var ans = 0
    var mx = 0
    for (v in nums) {
      val t = cnt[v % space]!!
      if (t > mx || t == mx && v < ans) {
        ans = v
        mx = t
      }
    }
    return ans
  }
}
