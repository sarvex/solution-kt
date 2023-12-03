class Solution {
  fun minOperations(nums: List<Int>, target: Int): Int {
    var s: Long = 0
    val cnt = IntArray(32)
    for (x in nums) {
      s += x.toLong()
      for (i in 0..31) {
        if (x shr i and 1 == 1) {
          ++cnt[i]
        }
      }
    }
    if (s < target) {
      return -1
    }
    var i = 0
    var j = 0
    var ans = 0
    while (true) {
      while (i < 32 && target shr i and 1 == 0) {
        ++i
      }
      if (i == 32) {
        return ans
      }
      while (j < i) {
        cnt[j + 1] += cnt[j] / 2
        cnt[j] %= 2
        ++j
      }
      while (cnt[j] == 0) {
        cnt[j] = 1
        ++j
      }
      ans += j - i
      --cnt[j]
      j = i
      ++i
    }
  }
}
