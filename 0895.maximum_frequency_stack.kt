import kotlin.math.max

internal class FreqStack {
  private val cnt: Map<Int, Int> = HashMap()
  private val d: Map<Int, Deque<Int>> = HashMap()
  private var mx = 0
  fun push(`val`: Int) {
    cnt.put(`val`, (cnt[`val`] ?: 0) + 1)
    val t = cnt[`val`]!!
    d.computeIfAbsent(t) { k -> ArrayDeque() }.push(`val`)
    mx = max(mx.toDouble(), t.toDouble()).toInt()
  }

  fun pop(): Int {
    val `val`: Int = d[mx].pop()
    cnt.put(`val`, cnt[`val`]!! - 1)
    if (d[mx].isEmpty()) {
      --mx
    }
    return `val`
  }
}
