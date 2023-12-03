internal class Solution {
  private var rooms: List<List<Int>>? = null
  private var vis: Set<Int>? = null
  fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    vis = HashSet()
    this.rooms = rooms
    dfs(0)
    return vis.size() === rooms.size()
  }

  private fun dfs(u: Int) {
    if (vis!!.contains(u)) {
      return
    }
    vis.add(u)
    for (v in rooms!![u]) {
      dfs(v)
    }
  }
}
