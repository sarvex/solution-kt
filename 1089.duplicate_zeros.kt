internal class Solution {
  fun duplicateZeros(arr: IntArray) {
    val n = arr.size
    var i = -1
    var k = 0
    while (k < n) {
      ++i
      k += if (arr[i] > 0) 1 else 2
    }
    var j = n - 1
    if (k == n + 1) {
      arr[j--] = 0
      --i
    }
    while (j >= 0) {
      arr[j] = arr[i]
      if (arr[i] == 0) {
        arr[--j] = arr[i]
      }
      --i
      --j
    }
  }
}
