internal class Solution {
  fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
    val n = img1.size
    val cnt: Map<List<Int>, Int> = HashMap()
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (img1[i][j] == 1) {
          for (h in 0 until n) {
            for (k in 0 until n) {
              if (img2[h][k] == 1) {
                val t: List<Int> = List.of(i - h, j - k)
                ans = Math.max(ans, cnt.merge(t, 1) { a: Int, b: Int -> Integer.sum(a, b) })
              }
            }
          }
        }
      }
    }
    return ans
  }
}
