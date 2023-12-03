internal class Solution {
  fun maxSubsequence(nums: IntArray, k: Int): IntArray {
    val ans = IntArray(k)
    val idx: List<Int> = ArrayList()
    val n = nums.size
    for (i in 0 until n) {
      idx.add(i)
    }
    idx.sort(Comparator.comparingInt { i -> -nums[i] })
    val t = IntArray(k)
    for (i in 0 until k) {
      t[i] = idx[i]
    }
    Arrays.sort(t)
    for (i in 0 until k) {
      ans[i] = nums[t[i]]
    }
    return ans
  }
}
