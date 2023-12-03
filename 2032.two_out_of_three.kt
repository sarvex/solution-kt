internal class Solution {
  fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
    val s1 = get(nums1)
    val s2 = get(nums2)
    val s3 = get(nums3)
    val ans: List<Int> = ArrayList()
    for (i in 1..100) {
      if (s1[i] + s2[i] + s3[i] > 1) {
        ans.add(i)
      }
    }
    return ans
  }

  private operator fun get(nums: IntArray): IntArray {
    val s = IntArray(101)
    for (num in nums) {
      s[num] = 1
    }
    return s
  }
}
