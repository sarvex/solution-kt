internal class Solution {
  fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
    var n = n
    val q: PriorityQueue<Int> = PriorityQueue()
    q.offer(1)
    var x = 0
    while (n-- > 0) {
      x = q.poll()
      while (!q.isEmpty() && q.peek() === x) {
        q.poll()
      }
      for (k in primes) {
        if (k <= Int.MAX_VALUE / x) {
          q.offer(k * x)
        }
        if (x % k == 0) {
          break
        }
      }
    }
    return x
  }
}
