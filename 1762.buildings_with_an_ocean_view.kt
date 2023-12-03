class Solution {
  fun findBuildings(heights: IntArray): IntArray {
    val n = heights.size
    val ans: List<Int> = ArrayList()
    var mx = 0
    for (i in heights.indices.reversed()) {
      if (heights[i] > mx) {
        ans.add(i)
        mx = heights[i]
      }
    }
    Collections.reverse(ans)
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }
}
