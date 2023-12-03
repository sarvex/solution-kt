import kotlin.math.min

class Solution {
  fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
    val n = packages.size
    val inf = 1L shl 62
    Arrays.sort(packages)
    var ans = inf
    for (box in boxes) {
      Arrays.sort(box)
      if (packages[n - 1] > box[box.size - 1]) {
        continue
      }
      var s: Long = 0
      var i = 0
      for (b in box) {
        val j = search(packages, b, i)
        s += 1L * (j - i) * b
        i = j
      }
      ans = min(ans.toDouble(), s.toDouble()).toLong()
    }
    if (ans == inf) {
      return -1
    }
    var s: Long = 0
    for (p in packages) {
      s += p.toLong()
    }
    val mod = 1e9.toInt() + 7
    return ((ans - s) % mod).toInt()
  }

  private fun search(nums: IntArray, x: Int, l: Int): Int {
    var l = l
    var r = nums.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] > x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
