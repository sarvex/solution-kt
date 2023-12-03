import kotlin.math.max

internal class Solution {
  fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    val dirs = intArrayOf(0, 1, 0, -1, 0)
    val s: Set<Int> = HashSet(obstacles.size)
    for (e in obstacles) {
      s.add(f(e[0], e[1]))
    }
    var ans = 0
    var k = 0
    var x = 0
    var y = 0
    for (c in commands) {
      if (c == -2) {
        k = (k + 3) % 4
      } else if (c == -1) {
        k = (k + 1) % 4
      } else {
        while (c-- > 0) {
          val nx = x + dirs[k]
          val ny = y + dirs[k + 1]
          if (s.contains(f(nx, ny))) {
            break
          }
          x = nx
          y = ny
          ans = max(ans.toDouble(), (x * x + y * y).toDouble()).toInt()
        }
      }
    }
    return ans
  }

  private fun f(x: Int, y: Int): Int {
    return x * 60010 + y
  }
}
