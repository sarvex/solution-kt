class Solution {
  fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val s1 = convert(nums1)
    val s2 = convert(nums2)
    val ans: List<List<Int>> = ArrayList()
    val l1: List<Int> = ArrayList()
    val l2: List<Int> = ArrayList()
    for (v in s1) {
      if (!s2.contains(v)) {
        l1.add(v)
      }
    }
    for (v in s2) {
      if (!s1.contains(v)) {
        l2.add(v)
      }
    }
    ans.add(l1)
    ans.add(l2)
    return ans
  }

  private fun convert(nums: IntArray): Set<Int> {
    val s: Set<Int> = HashSet()
    for (v in nums) {
      s.add(v)
    }
    return s
  }
}
