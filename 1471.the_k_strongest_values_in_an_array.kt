import kotlin.math.abs

class Solution {
  fun getStrongest(arr: IntArray, k: Int): IntArray {
    Arrays.sort(arr)
    val m = arr[arr.size - 1 shr 1]
    val nums: List<Int> = ArrayList()
    for (v in arr) {
      nums.add(v)
    }
    nums.sort { a, b ->
      val x: Int = abs((a - m).toDouble())
      val y: Int = abs((b - m).toDouble())
      if (x == y) b - a else y - x
    }
    val ans = IntArray(k)
    for (i in 0 until k) {
      ans[i] = nums[i]
    }
    return ans
  }
}
