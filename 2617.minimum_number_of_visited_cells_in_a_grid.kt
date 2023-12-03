class Solution {
  fun minimumVisitedCells(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dist = Array(m) { IntArray(n) }
    val row: Array<PriorityQueue<IntArray>?> = arrayOfNulls<PriorityQueue>(m)
    val col: Array<PriorityQueue<IntArray>?> = arrayOfNulls<PriorityQueue>(n)
    for (i in 0 until m) {
      Arrays.fill(dist[i], -1)
      row[i] = PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    }
    for (i in 0 until n) {
      col[i] = PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    }
    dist[0][0] = 1
    for (i in 0 until m) {
      for (j in 0 until n) {
        while (!row[i].isEmpty() && grid[i][row[i].peek().get(1)] + row[i].peek().get(1) < j) {
          row[i].poll()
        }
        if (!row[i].isEmpty() && (dist[i][j] == -1 || row[i].peek().get(0) + 1 < dist[i][j])) {
          dist[i][j] = row[i].peek().get(0) + 1
        }
        while (!col[j].isEmpty() && grid[col[j].peek().get(1)][j] + col[j].peek().get(1) < i) {
          col[j].poll()
        }
        if (!col[j].isEmpty() && (dist[i][j] == -1 || col[j].peek().get(0) + 1 < dist[i][j])) {
          dist[i][j] = col[j].peek().get(0) + 1
        }
        if (dist[i][j] != -1) {
          row[i].offer(intArrayOf(dist[i][j], j))
          col[j].offer(intArrayOf(dist[i][j], i))
        }
      }
    }
    return dist[m - 1][n - 1]
  }
}
