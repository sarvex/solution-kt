class Solution {
  fun findDiagonalOrder(nums: List<List<Int?>>): IntArray {
    val arr: List<IntArray> = ArrayList()
    for (i in 0 until nums.size()) {
      for (j in 0 until nums[i].size()) {
        arr.add(intArrayOf(i + j, j, nums[i][j]!!))
      }
    }
    arr.sort { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val ans = IntArray(arr.size())
    for (i in 0 until arr.size()) {
      ans[i] = arr[i][2]
    }
    return ans
  }
}
