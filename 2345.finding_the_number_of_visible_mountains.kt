class Solution {
  fun visibleMountains(peaks: Array<IntArray>): Int {
    val n = peaks.size
    val arr = Array(n) { IntArray(2) }
    val cnt: Map<String, Int> = HashMap()
    for (i in 0 until n) {
      val x = peaks[i][0]
      val y = peaks[i][1]
      arr[i] = intArrayOf(x - y, x + y)
      cnt.merge((x - y).toString() + "" + (x + y), 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    Arrays.sort(arr) { a, b -> if (a.get(0) === b.get(0)) b.get(1) - a.get(1) else a.get(0) - b.get(0) }
    var ans = 0
    var cur = Int.MIN_VALUE
    for (e in arr) {
      val l = e[0]
      val r = e[1]
      if (r <= cur) {
        continue
      }
      cur = r
      if (cnt[l.toString() + "" + r] === 1) {
        ++ans
      }
    }
    return ans
  }
}
