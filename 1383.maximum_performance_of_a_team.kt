import kotlin.math.max

class Solution {
  fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
    val t = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      t[i] = intArrayOf(speed[i], efficiency[i])
    }
    Arrays.sort(t) { a, b -> b.get(1) - a.get(1) }
    val q: PriorityQueue<Int> = PriorityQueue()
    var tot: Long = 0
    var ans: Long = 0
    for (x in t) {
      val s = x[0]
      val e = x[1]
      tot += s.toLong()
      ans = max(ans.toDouble(), (tot * e).toDouble()).toLong()
      q.offer(s)
      if (q.size() === k) {
        tot -= q.poll()
      }
    }
    return (ans % Solution.Companion.MOD).toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
