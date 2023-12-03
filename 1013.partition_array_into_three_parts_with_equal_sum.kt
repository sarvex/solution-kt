class Solution {
  fun canThreePartsEqualSum(arr: IntArray): Boolean {
    var s = 0
    for (v in arr) {
      s += v
    }
    if (s % 3 != 0) {
      return false
    }
    var i = 0
    var j = arr.size - 1
    var a = 0
    var b = 0
    while (i < arr.size) {
      a += arr[i]
      if (a == s / 3) {
        break
      }
      ++i
    }
    while (j >= 0) {
      b += arr[j]
      if (b == s / 3) {
        break
      }
      --j
    }
    return i < j - 1
  }
}
