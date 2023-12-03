class Solution {
  fun isPathCrossing(path: String): Boolean {
    var i = 0
    var j = 0
    val vis: Set<Int> = HashSet()
    vis.add(0)
    var k = 0
    val n = path.length
    while (k < n) {
      when (path[k]) {
        'N' -> --i
        'S' -> ++i
        'E' -> ++j
        'W' -> --j
      }
      val t = i * 20000 + j
      if (!vis.add(t)) {
        return true
      }
      ++k
    }
    return false
  }
}
