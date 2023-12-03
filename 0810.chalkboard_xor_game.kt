internal class Solution {
  fun xorGame(nums: IntArray): Boolean {
    return nums.size % 2 == 0 || Arrays.stream(nums).reduce(0) { a, b -> a xor b } === 0
  }
}
