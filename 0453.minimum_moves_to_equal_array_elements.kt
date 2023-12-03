internal class Solution {
  fun minMoves(nums: IntArray): Int {
    return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.size
  }
}
