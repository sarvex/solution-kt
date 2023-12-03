import kotlin.math.max

class Solution {
  private val mod = 1e9.toInt() + 7
  fun maxFrequencyScore(nums: IntArray, k: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (i in 0 until k) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var cur: Long = 0
    for (e in cnt.entrySet()) {
      cur = (cur + qpow(e.getKey(), e.getValue())) % mod
    }
    var ans = cur
    for (i in k until nums.size) {
      val a = nums[i - k]
      val b = nums[i]
      if (a != b) {
        cur += if (cnt[b] ?: 0 > 0) {
          (b - 1) * qpow(b.toLong(), cnt[b]) % mod
        } else {
          b.toLong()
        }
        cur -= if (cnt[a] ?: 0 > 1) {
          (a - 1) * qpow(a.toLong(), (cnt[a]!! - 1).toLong()) % mod
        } else {
          a.toLong()
        }
        cur = (cur + mod) % mod
        cnt.put(b, (cnt[b] ?: 0) + 1)
        cnt.put(a, (cnt[a] ?: 0) - 1)
        ans = max(ans.toDouble(), cur.toDouble()).toLong()
      }
    }
    return ans.toInt()
  }

  private fun qpow(a: Long, n: Long): Long {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1L == 1L) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans
  }
}
