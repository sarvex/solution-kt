internal class Solution {
  fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var right = right
    while (left < right) {
      right = right and right - 1
    }
    return right
  }
}
