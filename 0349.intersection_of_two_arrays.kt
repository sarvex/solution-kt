internal class Solution {
  fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val s = BooleanArray(1001)
    for (x in nums1) {
      s[x] = true
    }
    val ans: List<Int> = ArrayList()
    for (x in nums2) {
      if (s[x]) {
        ans.add(x)
        s[x] = false
      }
    }
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }
}
