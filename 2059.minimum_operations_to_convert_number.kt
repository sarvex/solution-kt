internal class Solution {
  fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
    val op1 = IntBinaryOperator { x, y -> x + y }
    val op2 = IntBinaryOperator { x, y -> x - y }
    val op3 = IntBinaryOperator { x, y -> x xor y }
    val ops: Array<IntBinaryOperator> = arrayOf<IntBinaryOperator>(op1, op2, op3)
    val vis = BooleanArray(1001)
    val queue: Queue<IntArray> = ArrayDeque()
    queue.offer(intArrayOf(start, 0))
    while (!queue.isEmpty()) {
      val p: IntArray = queue.poll()
      val x = p[0]
      val step = p[1]
      for (num in nums) {
        for (op in ops) {
          val nx: Int = op.applyAsInt(x, num)
          if (nx == goal) {
            return step + 1
          }
          if (nx >= 0 && nx <= 1000 && !vis[nx]) {
            queue.offer(intArrayOf(nx, step + 1))
            vis[nx] = true
          }
        }
      }
    }
    return -1
  }
}
