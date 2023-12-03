import kotlin.math.min

internal class Solution {
  fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
    var start = start
    val s: Int = Arrays.stream(distance).sum()
    val n = distance.size
    var a = 0
    while (start != destination) {
      a += distance[start]
      start = (start + 1) % n
    }
    return min(a.toDouble(), (s - a).toDouble()).toInt()
  }
}
