internal class Solution(w: IntArray) {
  private val s: IntArray
  private val random: Random = Random()

  init {
    val n = w.size
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + w[i]
    }
  }

  fun pickIndex(): Int {
    val x: Int = 1 + random.nextInt(s[s.size - 1])
    var left = 1
    var right = s.size - 1
    while (left < right) {
      val mid = left + right shr 1
      if (s[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left - 1
  }
}
