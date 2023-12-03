internal class Solution(rects: Array<IntArray>) {
  private val s: IntArray
  private val rects: Array<IntArray>
  private val random: Random = Random()

  init {
    val n = rects.size
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1)
    }
    this.rects = rects
  }

  fun pick(): IntArray {
    val n = rects.size
    val v: Int = 1 + random.nextInt(s[n])
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + right shr 1
      if (s[mid] >= v) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    val rect = rects[left - 1]
    return intArrayOf(
      rect[0] + random.nextInt(rect[2] - rect[0] + 1),
      rect[1] + random.nextInt(rect[3] - rect[1] + 1)
    )
  }
}
