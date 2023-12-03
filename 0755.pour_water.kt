internal class Solution {
  fun pourWater(heights: IntArray, volume: Int, k: Int): IntArray {
    var volume = volume
    while (volume-- > 0) {
      var find = false
      var d = -1
      while (d < 2 && !find) {
        var i = k
        var j = k
        while (i + d >= 0 && i + d < heights.size && heights[i + d] <= heights[i]) {
          if (heights[i + d] < heights[i]) {
            j = i + d
          }
          i += d
        }
        if (j != k) {
          find = true
          ++heights[j]
        }
        d += 2
      }
      if (!find) {
        ++heights[k]
      }
    }
    return heights
  }
}
