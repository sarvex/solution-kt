internal class Solution {
  fun trapRainWater(heightMap: Array<IntArray>): Int {
    val m = heightMap.size
    val n = heightMap[0].size
    val vis = Array(m) { BooleanArray(n) }
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
          pq.offer(intArrayOf(heightMap[i][j], i, j))
          vis[i][j] = true
        }
      }
    }
    var ans = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!pq.isEmpty()) {
      val p: Unit = pq.poll()
      for (k in 0..3) {
        val x: Int = p.get(1) + dirs[k]
        val y: Int = p.get(2) + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
          ans += Math.max(0, p.get(0) - heightMap[x][y])
          vis[x][y] = true
          pq.offer(intArrayOf(Math.max(p.get(0), heightMap[x][y]), x, y))
        }
      }
    }
    return ans
  }
}
