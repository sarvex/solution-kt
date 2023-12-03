class Solution {
  fun encode(num: Int): String {
    return Integer.toBinaryString(num + 1).substring(1)
  }
}
