import kotlin.math.max

class Solution {
  fun minSetSize(arr: IntArray): Int {
    var mx = 0
    for (x in arr) {
      mx = max(mx.toDouble(), x.toDouble()).toInt()
    }
    val cnt = IntArray(mx + 1)
    for (x in arr) {
      ++cnt[x]
    }
    Arrays.sort(cnt)
    var ans = 0
    var m = 0
    var i = mx
    while (true) {
      if (cnt[i] > 0) {
        m += cnt[i]
        ++ans
        if (m * 2 >= arr.size) {
          return ans
        }
      }
      --i
    }
  }
}
