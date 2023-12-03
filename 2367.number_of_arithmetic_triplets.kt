class Solution {
  fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    val vis = BooleanArray(301)
    for (x in nums) {
      vis[x] = true
    }
    var ans = 0
    for (x in nums) {
      if (vis[x + diff] && vis[x + diff + diff]) {
        ++ans
      }
    }
    return ans
  }
}
