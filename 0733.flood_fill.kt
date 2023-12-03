internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private var image: Array<IntArray>
  private var nc = 0
  private var oc = 0
  fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    nc = color
    oc = image[sr][sc]
    this.image = image
    dfs(sr, sc)
    return image
  }

  private fun dfs(i: Int, j: Int) {
    if (i < 0 || i >= image.size || j < 0 || j >= image[0].size || image[i][j] != oc || image[i][j] == nc) {
      return
    }
    image[i][j] = nc
    for (k in 0..3) {
      dfs(i + dirs[k], j + dirs[k + 1])
    }
  }
}
