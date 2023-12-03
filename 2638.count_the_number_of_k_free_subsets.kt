class Solution {
  fun countTheNumOfKFreeSubsets(nums: IntArray, k: Int): Long {
    Arrays.sort(nums)
    val g: Map<Int, List<Int>> = HashMap()
    for (i in nums.indices) {
      g.computeIfAbsent(nums[i] % k) { x -> ArrayList() }.add(nums[i])
    }
    var ans: Long = 1
    for (arr in g.values()) {
      val m: Int = arr.size()
      val f = LongArray(m + 1)
      f[0] = 1
      f[1] = 2
      for (i in 2..m) {
        if (arr.get(i - 1) - arr.get(i - 2) === k) {
          f[i] = f[i - 1] + f[i - 2]
        } else {
          f[i] = f[i - 1] * 2
        }
      }
      ans *= f[m]
    }
    return ans
  }
}
