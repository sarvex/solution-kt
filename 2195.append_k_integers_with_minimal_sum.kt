import kotlin.math.min

class Solution {
  fun minimalKSum(nums: IntArray, k: Int): Long {
    var k = k
    val arr = IntArray(nums.size + 2)
    arr[arr.size - 1] = 2e9.toInt()
    for (i in nums.indices) {
      arr[i + 1] = nums[i]
    }
    Arrays.sort(arr)
    var ans: Long = 0
    for (i in 1 until arr.size) {
      val a = arr[i - 1]
      val b = arr[i]
      val n = min(k.toDouble(), (b - a - 1).toDouble()).toInt()
      if (n <= 0) {
        continue
      }
      k -= n
      ans += (a + 1 + a + n).toLong() * n / 2
      if (k == 0) {
        break
      }
    }
    return ans
  }
}
