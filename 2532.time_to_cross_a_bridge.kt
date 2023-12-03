class Solution {
  fun findCrossingTime(n: Int, k: Int, time: Array<IntArray>): Int {
    var n = n
    val t = Array(k) { IntArray(5) }
    for (i in 0 until k) {
      val x = time[i]
      t[i] = intArrayOf(x[0], x[1], x[2], x[3], i)
    }
    Arrays.sort(t) { a, b ->
      val x: Int = a.get(0) + a.get(2)
      val y: Int = b.get(0) + b.get(2)
      if (x == y) a.get(4) - b.get(4) else x - y
    }
    var cur = 0
    val waitInLeft: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    val waitInRight: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    val workInLeft: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    val workInRight: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (i in 0 until k) {
      waitInLeft.offer(i)
    }
    while (true) {
      while (!workInLeft.isEmpty()) {
        val p: IntArray = workInLeft.peek()
        if (p[0] > cur) {
          break
        }
        waitInLeft.offer(workInLeft.poll().get(1))
      }
      while (!workInRight.isEmpty()) {
        val p: IntArray = workInRight.peek()
        if (p[0] > cur) {
          break
        }
        waitInRight.offer(workInRight.poll().get(1))
      }
      val leftToGo = n > 0 && !waitInLeft.isEmpty()
      val rightToGo: Boolean = !waitInRight.isEmpty()
      if (!leftToGo && !rightToGo) {
        var nxt = 1 shl 30
        if (!workInLeft.isEmpty()) {
          nxt = Math.min(nxt, workInLeft.peek().get(0))
        }
        if (!workInRight.isEmpty()) {
          nxt = Math.min(nxt, workInRight.peek().get(0))
        }
        cur = nxt
        continue
      }
      if (rightToGo) {
        val i: Int = waitInRight.poll()
        cur += t[i][2]
        if (n == 0 && waitInRight.isEmpty() && workInRight.isEmpty()) {
          return cur
        }
        workInLeft.offer(intArrayOf(cur + t[i][3], i))
      } else {
        val i: Int = waitInLeft.poll()
        cur += t[i][0]
        --n
        workInRight.offer(intArrayOf(cur + t[i][1], i))
      }
    }
  }
}
