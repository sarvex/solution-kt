internal class Solution {
  fun recoverArray(nums: IntArray): IntArray? {
    Arrays.sort(nums)
    var i = 1
    val n = nums.size
    while (i < n) {
      val d = nums[i] - nums[0]
      if (d == 0 || d % 2 == 1) {
        ++i
        continue
      }
      val vis = BooleanArray(n)
      vis[i] = true
      val t: List<Int> = ArrayList()
      t.add(nums[0] + nums[i] shr 1)
      var l = 1
      var r = i + 1
      while (r < n) {
        while (l < n && vis[l]) {
          ++l
        }
        while (r < n && nums[r] - nums[l] < d) {
          ++r
        }
        if (r == n || nums[r] - nums[l] > d) {
          break
        }
        vis[r] = true
        t.add(nums[l] + nums[r] shr 1)
        ++l
        ++r
      }
      if (t.size() === n shr 1) {
        val ans = IntArray(t.size())
        var idx = 0
        for (e in t) {
          ans[idx++] = e
        }
        return ans
      }
      ++i
    }
    return null
  }
}
