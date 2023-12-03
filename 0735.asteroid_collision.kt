internal class Solution {
  fun asteroidCollision(asteroids: IntArray): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    for (x in asteroids) {
      if (x > 0) {
        stk.offerLast(x)
      } else {
        while (!stk.isEmpty() && stk.peekLast() > 0 && stk.peekLast() < -x) {
          stk.pollLast()
        }
        if (!stk.isEmpty() && stk.peekLast() === -x) {
          stk.pollLast()
        } else if (stk.isEmpty() || stk.peekLast() < 0) {
          stk.offerLast(x)
        }
      }
    }
    return stk.stream().mapToInt(Integer::valueOf).toArray()
  }
}
