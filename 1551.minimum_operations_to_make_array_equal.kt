class Solution {
  fun minOperations(n: Int): Int {
    var ans = 0
    for (i in 0 until (n shr 1)) {
      ans += n - (i shl 1 or 1)
    }
    return ans
  }
}
