class Solution {
  fun minSwaps(s: String): Int {
    var ans = 0
    for (c in s.toCharArray()) {
      if (c == '[') {
        ++ans
      } else if (ans > 0) {
        --ans
      }
    }
    return ans + 1 shr 1
  }
}
