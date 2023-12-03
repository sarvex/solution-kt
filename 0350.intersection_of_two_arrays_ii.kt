internal class Solution {
  fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val counter: Map<Int, Int> = HashMap()
    for (num in nums1) {
      counter.put(num, (counter[num] ?: 0) + 1)
    }
    val t: List<Int> = ArrayList()
    for (num in nums2) {
      if (counter[num] ?: 0 > 0) {
        t.add(num)
        counter.put(num, counter[num]!! - 1)
      }
    }
    val res = IntArray(t.size())
    for (i in res.indices) {
      res[i] = t[i]
    }
    return res
  }
}
