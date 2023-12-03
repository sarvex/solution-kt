import java.util.Deque
import kotlin.collections.ArrayDeque

class Solution {
  fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
    val n = cars.size
    val ans = DoubleArray(n)
    Arrays.fill(ans, -1.0)
    val stk: Deque<Int> = ArrayDeque()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty()) {
        val j = stk.peek()
        if (cars[i][1] > cars[j][1]) {
          val t = (cars[j][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[j][1])
          if (ans[j] < 0 || t <= ans[j]) {
            ans[i] = t
            break
          }
        }
        stk.pop()
      }
      stk.push(i)
    }
    return ans
  }
}
