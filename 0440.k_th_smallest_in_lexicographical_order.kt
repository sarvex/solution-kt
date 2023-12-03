import kotlin.math.min

internal class Solution {
  private var n = 0
  fun findKthNumber(n: Int, k: Int): Int {
    var k = k
    this.n = n
    var curr: Long = 1
    --k
    while (k > 0) {
      val cnt = count(curr)
      if (k >= cnt) {
        k -= cnt
        ++curr
      } else {
        --k
        curr *= 10
      }
    }
    return curr.toInt()
  }

  fun count(curr: Long): Int {
    var curr = curr
    var next = curr + 1
    var cnt: Long = 0
    while (curr <= n) {
      (cnt += min((n - curr + 1).toDouble(), (next - curr).toDouble())).toLong()
      next *= 10
      curr *= 10
    }
    return cnt.toInt()
  }
}
