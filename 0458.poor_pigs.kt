internal class Solution {
  fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
    val base = minutesToTest / minutesToDie + 1
    var res = 0
    var p = 1
    while (p < buckets) {
      ++res
      p *= base
    }
    return res
  }
}
