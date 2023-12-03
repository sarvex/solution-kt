internal class Solution {
  fun heightChecker(heights: IntArray): Int {
    val expected = heights.clone()
    Arrays.sort(expected)
    var ans = 0
    for (i in heights.indices) {
      if (heights[i] != expected[i]) {
        ++ans
      }
    }
    return ans
  }
}
