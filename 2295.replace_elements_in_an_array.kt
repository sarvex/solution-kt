class Solution {
  fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
    val d: Map<Int, Int> = HashMap()
    for (i in nums.indices) {
      d.put(nums[i], i)
    }
    for (op in operations) {
      val a = op[0]
      val b = op[1]
      nums[d[a]!!] = b
      d.put(b, d[a])
    }
    return nums
  }
}
