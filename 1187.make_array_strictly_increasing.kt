import kotlin.math.min

internal class Solution {
  fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
    Arrays.sort(arr2)
    var m = 0
    for (x in arr2) {
      if (m == 0 || x != arr2[m - 1]) {
        arr2[m++] = x
      }
    }
    val inf = 1 shl 30
    val arr = IntArray(arr1.size + 2)
    arr[0] = -inf
    arr[arr.size - 1] = inf
    System.arraycopy(arr1, 0, arr, 1, arr1.size)
    val f = IntArray(arr.size)
    Arrays.fill(f, inf)
    f[0] = 0
    for (i in 1 until arr.size) {
      if (arr[i - 1] < arr[i]) {
        f[i] = f[i - 1]
      }
      val j = search(arr2, arr[i], m)
      for (k in 1..min((i - 1).toDouble(), j.toDouble()).toInt()) {
        if (arr[i - k - 1] < arr2[j - k]) {
          f[i] = min(f[i].toDouble(), (f[i - k - 1] + k).toDouble()).toInt()
        }
      }
    }
    return if (f[arr.size - 1] >= inf) -1 else f[arr.size - 1]
  }

  private fun search(nums: IntArray, x: Int, n: Int): Int {
    var l = 0
    var r = n
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
