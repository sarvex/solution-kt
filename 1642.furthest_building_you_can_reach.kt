class Solution {
  fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    var bricks = bricks
    val q: PriorityQueue<Int> = PriorityQueue()
    val n = heights.size
    for (i in 0 until n - 1) {
      val a = heights[i]
      val b = heights[i + 1]
      val d = b - a
      if (d > 0) {
        q.offer(d)
        if (q.size() > ladders) {
          bricks -= q.poll()
          if (bricks < 0) {
            return i
          }
        }
      }
    }
    return n - 1
  }
}
