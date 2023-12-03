import kotlin.math.min

class CustomStack(maxSize: Int) {
  private val stk: IntArray
  private val add: IntArray
  private var i = 0

  init {
    stk = IntArray(maxSize)
    add = IntArray(maxSize)
  }

  fun push(x: Int) {
    if (i < stk.size) {
      stk[i++] = x
    }
  }

  fun pop(): Int {
    if (i <= 0) {
      return -1
    }
    val ans = stk[--i] + add[i]
    if (i > 0) {
      add[i - 1] += add[i]
    }
    add[i] = 0
    return ans
  }

  fun increment(k: Int, `val`: Int) {
    if (i > 0) {
      add[(min(i.toDouble(), k.toDouble()) - 1).toInt()] += `val`
    }
  }
}
