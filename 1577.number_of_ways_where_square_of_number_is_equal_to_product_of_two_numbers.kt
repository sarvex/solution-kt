class Solution {
  fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
    val cnt1: Map<Int, Int> = HashMap()
    val cnt2: Map<Int, Int> = HashMap()
    for (v in nums1) {
      cnt1.put(v, (cnt1[v] ?: 0) + 1)
    }
    for (v in nums2) {
      cnt2.put(v, (cnt2[v] ?: 0) + 1)
    }
    var ans: Long = 0
    for (e1 in cnt1.entrySet()) {
      val a: Long = e1.getKey()
      val x: Long = e1.getValue()
      for (e2 in cnt2.entrySet()) {
        val b: Long = e2.getKey()
        val y: Long = e2.getValue()
        if (a * a % b == 0L) {
          val c = a * a / b
          ans += if (b == c) {
            x * y * (y - 1)
          } else {
            x * y * (cnt2[c.toInt()] ?: 0)
          }
        }
        if (b * b % a == 0L) {
          val c = b * b / a
          ans += if (a == c) {
            x * (x - 1) * y
          } else {
            x * y * (cnt1[c.toInt()] ?: 0)
          }
        }
      }
    }
    return (ans shr 1).toInt()
  }
}
