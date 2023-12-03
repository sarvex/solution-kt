internal class Solution {
  fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals) { a, b -> if (a.get(1) === b.get(1)) b.get(0) - a.get(0) else a.get(1) - b.get(1) }
    var ans = 0
    var s = -1
    var e = -1
    for (v in intervals) {
      val a = v[0]
      val b = v[1]
      if (a <= s) {
        continue
      }
      if (a > e) {
        ans += 2
        s = b - 1
        e = b
      } else {
        ans += 1
        s = e
        e = b
      }
    }
    return ans
  }
}
