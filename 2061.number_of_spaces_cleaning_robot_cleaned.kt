internal class Solution {
  private var vis: Array<Array<BooleanArray>>
  private var room: Array<IntArray>
  private var ans = 0
  fun numberOfCleanRooms(room: Array<IntArray>): Int {
    vis = Array(room.size) { Array(room[0].size) { BooleanArray(4) } }
    this.room = room
    dfs(0, 0, 0)
    return ans
  }

  private fun dfs(i: Int, j: Int, k: Int) {
    if (vis[i][j][k]) {
      return
    }
    val dirs = intArrayOf(0, 1, 0, -1, 0)
    ans += if (room[i][j] == 0) 1 else 0
    room[i][j] = -1
    vis[i][j][k] = true
    val x = i + dirs[k]
    val y = j + dirs[k + 1]
    if (x >= 0 && x < room.size && y >= 0 && y < room[0].size && room[x][y] != 1) {
      dfs(x, y, k)
    } else {
      dfs(i, j, (k + 1) % 4)
    }
  }
}
