import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
    var area: Long = 0
    var minX = rectangles[0][0]
    var minY = rectangles[0][1]
    var maxX = rectangles[0][2]
    var maxY = rectangles[0][3]
    val cnt: Map<Solution.Pair, Int> = HashMap()
    for (r in rectangles) {
      area += ((r[2] - r[0]) * (r[3] - r[1])).toLong()
      minX = min(minX.toDouble(), r[0].toDouble()).toInt()
      minY = min(minY.toDouble(), r[1].toDouble()).toInt()
      maxX = max(maxX.toDouble(), r[2].toDouble()).toInt()
      maxY = max(maxY.toDouble(), r[3].toDouble()).toInt()
      cnt.merge(Solution.Pair(r[0], r[1]), 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(Solution.Pair(r[0], r[3]), 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(Solution.Pair(r[2], r[3]), 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(Solution.Pair(r[2], r[1]), 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    if (area != (maxX - minX).toLong() * (maxY - minY) || cnt[Solution.Pair(
        minX,
        minY
      )] ?: 0 !== 1 || cnt[Solution.Pair(minX, maxY)] ?: 0 !== 1 || cnt[Solution.Pair(
        maxX,
        maxY
      )] ?: 0 !== 1 || cnt[Solution.Pair(maxX, minY)] ?: 0 !== 1
    ) {
      return false
    }
    cnt.remove(Solution.Pair(minX, minY))
    cnt.remove(Solution.Pair(minX, maxY))
    cnt.remove(Solution.Pair(maxX, maxY))
    cnt.remove(Solution.Pair(maxX, minY))
    return cnt.values().stream().allMatch { c -> c === 2 || c === 4 }
  }

  private class Pair internal constructor(val first: Int, val second: Int) {
    override fun equals(o: Any?): Boolean {
      if (this === o) {
        return true
      }
      if (o == null || javaClass != o.javaClass) {
        return false
      }
      val pair: Solution.Pair = o as Solution.Pair
      return first == pair.first && second == pair.second
    }

    override fun hashCode(): Int {
      return Objects.hash(first, second)
    }
  }
}
