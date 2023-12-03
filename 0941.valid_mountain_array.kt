class Solution {
  fun validMountainArray(arr: IntArray): Boolean {
    val n = arr.size
    if (n < 3) {
      return false
    }
    var l = 0
    var r = n - 1
    while (l + 1 < n - 1 && arr[l] < arr[l + 1]) {
      ++l
    }
    while (r - 1 > 0 && arr[r] < arr[r - 1]) {
      --r
    }
    return l == r
  }
}
