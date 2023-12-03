class Solution {
  fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
    Arrays.sort(arr2)
    var ans = 0
    for (a in arr1) {
      if (check(arr2, a, d)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(arr: IntArray, a: Int, d: Int): Boolean {
    var l = 0
    var r = arr.size
    while (l < r) {
      val mid = l + r shr 1
      if (arr[mid] >= a - d) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l >= arr.size || arr[l] > a + d
  }
}
