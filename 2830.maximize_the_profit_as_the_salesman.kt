class Solution {
  fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
    var n = n
    offers.sort { a, b -> a.get(1) - b.get(1) }
    n = offers.size()
    val f = IntArray(n + 1)
    val g = IntArray(n)
    for (i in 0 until n) {
      g[i] = offers[i][1]
    }
    for (i in 1..n) {
      val o: Unit = offers[i - 1]
      val j = search(g, o.get(0))
      f[i] = Math.max(f[i - 1], f[j] + o.get(2))
    }
    return f[n]
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
