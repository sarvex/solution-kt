class Solution {
  fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
    val n = nums.size
    val target: List<Int> = ArrayList()
    for (i in 0 until n) {
      target.add(index[i], nums[i])
    }
    // return target.stream().mapToInt(i -> i).toArray();
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = target[i]
    }
    return ans
  }
}
