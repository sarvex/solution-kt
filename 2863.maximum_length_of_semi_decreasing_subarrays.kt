class Solution {
  fun maxSubarrayLength(nums: IntArray): Int {
    val d: TreeMap<Int, List<Int>> = TreeMap(Comparator.reverseOrder())
    for (i in nums.indices) {
      d.computeIfAbsent(nums[i]) { k -> ArrayList() }.add(i)
    }
    var ans = 0
    var k = 1 shl 30
    for (idx in d.values()) {
      ans = Math.max(ans, idx[idx.size() - 1] - k + 1)
      k = Math.min(k, idx[0])
    }
    return ans
  }
}
