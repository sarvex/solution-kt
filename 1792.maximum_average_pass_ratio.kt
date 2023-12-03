class Solution {
  fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
    var extraStudents = extraStudents
    val pq: PriorityQueue<DoubleArray> = PriorityQueue { a, b ->
      val x: Double = (a.get(0) + 1) / (a.get(1) + 1) - a.get(0) / a.get(1)
      val y: Double = (b.get(0) + 1) / (b.get(1) + 1) - b.get(0) / b.get(1)
      java.lang.Double.compare(y, x)
    }
    for (e in classes) {
      pq.offer(doubleArrayOf(e[0].toDouble(), e[1].toDouble()))
    }
    while (extraStudents-- > 0) {
      val e: Unit = pq.poll()
      val a: Double = e.get(0) + 1
      val b: Double = e.get(1) + 1
      pq.offer(doubleArrayOf(a, b))
    }
    var ans = 0.0
    while (!pq.isEmpty()) {
      val e: Unit = pq.poll()
      ans += e.get(0) / e.get(1)
    }
    return ans / classes.size
  }
}
