internal class Solution {
  fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    val n = arr.size
    val pq: Queue<Frac> = PriorityQueue()
    for (i in 1 until n) {
      pq.offer(Frac(1, arr[i], 0, i))
    }
    for (i in 1 until k) {
      val f: Frac = pq.poll()
      if (f.i + 1 < f.j) {
        pq.offer(Frac(arr[f.i + 1], arr[f.j], f.i + 1, f.j))
      }
    }
    val f: Frac = pq.peek()
    return intArrayOf(f.x, f.y)
  }

  internal class Frac(var x: Int, var y: Int, var i: Int, var j: Int) : Comparable<Any?> {
    override operator fun compareTo(o: Any): Int {
      return x * (o as Frac).y - o.x * y
    }
  }
}
