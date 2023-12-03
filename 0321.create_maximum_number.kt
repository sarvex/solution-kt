import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    val m = nums1.size
    val n = nums2.size
    val l = max(0.0, (k - n).toDouble()).toInt()
    val r = min(k.toDouble(), m.toDouble()).toInt()
    var ans = IntArray(k)
    for (x in l..r) {
      val arr1 = f(nums1, x)
      val arr2 = f(nums2, k - x)
      val arr = merge(arr1, arr2)
      if (compare(arr, ans, 0, 0)) {
        ans = arr
      }
    }
    return ans
  }

  private fun f(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val stk = IntArray(k)
    var top = -1
    var remain = n - k
    for (x in nums) {
      while (top >= 0 && stk[top] < x && remain > 0) {
        --top
        --remain
      }
      if (top + 1 < k) {
        stk[++top] = x
      } else {
        --remain
      }
    }
    return stk
  }

  private fun merge(nums1: IntArray, nums2: IntArray): IntArray {
    val m = nums1.size
    val n = nums2.size
    var i = 0
    var j = 0
    val ans = IntArray(m + n)
    for (k in 0 until m + n) {
      if (compare(nums1, nums2, i, j)) {
        ans[k] = nums1[i++]
      } else {
        ans[k] = nums2[j++]
      }
    }
    return ans
  }

  private fun compare(nums1: IntArray, nums2: IntArray, i: Int, j: Int): Boolean {
    if (i >= nums1.size) {
      return false
    }
    if (j >= nums2.size) {
      return true
    }
    if (nums1[i] > nums2[j]) {
      return true
    }
    return if (nums1[i] < nums2[j]) {
      false
    } else compare(nums1, nums2, i + 1, j + 1)
  }
}
