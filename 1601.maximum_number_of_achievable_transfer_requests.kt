class Solution {
  private var m = 0
  private var n = 0
  private var requests: Array<IntArray>
  fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
    m = requests.size
    this.n = n
    this.requests = requests
    var ans = 0
    for (mask in 0 until (1 shl m)) {
      val cnt = Integer.bitCount(mask)
      if (ans < cnt && check(mask)) {
        ans = cnt
      }
    }
    return ans
  }

  private fun check(mask: Int): Boolean {
    val cnt = IntArray(n)
    for (i in 0 until m) {
      if (mask shr i and 1 == 1) {
        val f = requests[i][0]
        val t = requests[i][1]
        --cnt[f]
        ++cnt[t]
      }
    }
    for (v in cnt) {
      if (v != 0) {
        return false
      }
    }
    return true
  }
}
