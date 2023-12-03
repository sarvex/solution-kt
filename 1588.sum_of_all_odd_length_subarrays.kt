class Solution {
  fun sumOddLengthSubarrays(arr: IntArray): Int {
    val n = arr.size
    var ans = 0
    for (i in 0 until n) {
      var s = 0
      for (j in i until n) {
        s += arr[j]
        if ((j - i + 1) % 2 == 1) {
          ans += s
        }
      }
    }
    return ans
  }
}
