import kotlin.math.max

internal class Solution {
  fun maximalRectangle(matrix: Array<CharArray>): Int {
    val n = matrix[0].size
    val heights = IntArray(n)
    var ans = 0
    for (row in matrix) {
      for (j in 0 until n) {
        if (row[j] == '1') {
          heights[j] += 1
        } else {
          heights[j] = 0
        }
      }
      ans = max(ans.toDouble(), largestRectangleArea(heights).toDouble()).toInt()
    }
    return ans
  }

  private fun largestRectangleArea(heights: IntArray): Int {
    var res = 0
    val n = heights.size
    val stk: Deque<Int> = ArrayDeque()
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(right, n)
    for (i in 0 until n) {
      while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
        right[stk.pop()] = i
      }
      left[i] = if (stk.isEmpty()) -1 else stk.peek()
      stk.push(i)
    }
    for (i in 0 until n) {
      res = max(res.toDouble(), (heights[i] * (right[i] - left[i] - 1)).toDouble()).toInt()
    }
    return res
  }
}
