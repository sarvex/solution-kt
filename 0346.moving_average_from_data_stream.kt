import kotlin.math.min

internal class MovingAverage(size: Int) {
  private val arr: IntArray
  private var s = 0
  private var cnt = 0

  init {
    arr = IntArray(size)
  }

  fun next(`val`: Int): Double {
    val idx = cnt % arr.size
    s += `val` - arr[idx]
    arr[idx] = `val`
    ++cnt
    return s * 1.0 / min(cnt.toDouble(), arr.size.toDouble())
  }
}
