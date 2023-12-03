internal class Solution {
  fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
    val map: Map<Int, Set<Int>> = HashMap()
    for (i in nums2.indices) {
      map.computeIfAbsent(nums2[i]) { k -> HashSet() }.add(i)
    }
    val res = IntArray(nums1.size)
    for (i in nums1.indices) {
      val idx = map[nums1[i]]!!.iterator().next()
      res[i] = idx
      map[nums1[i]].remove(idx)
    }
    return res
  }
}
