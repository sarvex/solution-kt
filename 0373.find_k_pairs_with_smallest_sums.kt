import kotlin.math.min

internal class Solution {
  fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    var k = k
    val q: PriorityQueue<IntArray> = PriorityQueue(Comparator.comparingInt { a -> a.get(0) })
    for (i in 0 until min(nums1.size.toDouble(), k.toDouble()).toInt()) {
      q.offer(intArrayOf(nums1[i] + nums2[0], i, 0))
    }
    val ans: List<List<Int>> = ArrayList()
    while (!q.isEmpty() && k > 0) {
      val e: IntArray = q.poll()
      ans.add(Arrays.asList(nums1[e[1]], nums2[e[2]]))
      --k
      if (e[2] + 1 < nums2.size) {
        q.offer(intArrayOf(nums1[e[1]] + nums2[e[2] + 1], e[1], e[2] + 1))
      }
    }
    return ans
  }
}
