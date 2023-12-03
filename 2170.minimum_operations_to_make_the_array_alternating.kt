import kotlin.math.min

class Solution {
  private var nums: IntArray
  private var n = 0
  fun minimumOperations(nums: IntArray): Int {
    this.nums = nums
    n = nums.size
    var ans = Int.MAX_VALUE
    for (e1 in get(0)) {
      for (e2 in get(1)) {
        if (e1[0] != e2[0]) {
          ans = min(ans.toDouble(), (n - (e1[1] + e2[1])).toDouble()).toInt()
        }
      }
    }
    return ans
  }

  private operator fun get(i: Int): Array<IntArray> {
    var i = i
    val freq: Map<Int, Int> = HashMap()
    while (i < n) {
      freq.put(nums[i], (freq[nums[i]] ?: 0) + 1)
      i += 2
    }
    var a = 0
    var n1 = 0
    var b = 0
    var n2 = 0
    for (e in freq.entrySet()) {
      val k: Int = e.getKey()
      val v: Int = e.getValue()
      if (v > n1) {
        b = a
        n2 = n1
        a = k
        n1 = v
      } else if (v > n2) {
        b = k
        n2 = v
      }
    }
    return arrayOf(intArrayOf(a, n1), intArrayOf(b, n2))
  }
}
