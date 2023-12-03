internal class Solution {
  fun isRobotBounded(instructions: String): Boolean {
    var k = 0
    val dist = IntArray(4)
    for (i in 0 until instructions.length) {
      val c = instructions[i]
      if (c == 'L') {
        k = (k + 1) % 4
      } else if (c == 'R') {
        k = (k + 3) % 4
      } else {
        ++dist[k]
      }
    }
    return dist[0] == dist[2] && dist[1] == dist[3] || k != 0
  }
}
