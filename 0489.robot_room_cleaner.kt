/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 * // Returns true if the cell in front is open and robot moves into the cell.
 * // Returns false if the cell in front is blocked and robot stays in the current cell.
 * public boolean move();
 *
 * // Robot will stay in the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * public void turnLeft();
 * public void turnRight();
 *
 * // Clean the current cell.
 * public void clean();
 * }
 */
internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private val vis: Set<List<Int>> = HashSet()
  private var robot: Robot? = null
  fun cleanRoom(robot: Robot?) {
    this.robot = robot
    dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, d: Int) {
    robot.clean()
    vis.add(List.of(i, j))
    for (k in 0..3) {
      val nd = (d + k) % 4
      val x = i + dirs[nd]
      val y = j + dirs[nd + 1]
      if (!vis.contains(List.of(x, y)) && robot.move()) {
        dfs(x, y, nd)
        robot.turnRight()
        robot.turnRight()
        robot.move()
        robot.turnRight()
        robot.turnRight()
      }
      robot.turnRight()
    }
  }
}
