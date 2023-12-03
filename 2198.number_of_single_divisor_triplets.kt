class Solution {
  fun singleDivisorTriplet(nums: IntArray): Long {
    val counter = IntArray(101)
    for (x in nums) {
      ++counter[x]
    }
    var ans: Long = 0
    for (i in 1..100) {
      for (j in 1..100) {
        for (k in 1..100) {
          val cnt1 = counter[i]
          val cnt2 = counter[j]
          val cnt3 = counter[k]
          val s = i + j + k
          var cnt = 0
          if (s % i == 0) {
            ++cnt
          }
          if (s % j == 0) {
            ++cnt
          }
          if (s % k == 0) {
            ++cnt
          }
          if (cnt != 1) {
            continue
          }
          ans += if (i == j) {
            cnt1.toLong() * (cnt1 - 1) * cnt3
          } else if (i == k) {
            cnt1.toLong() * (cnt1 - 1) * cnt2
          } else if (j == k) {
            cnt1.toLong() * cnt2 * (cnt2 - 1)
          } else {
            cnt1.toLong() * cnt2 * cnt3
          }
        }
      }
    }
    return ans
  }
}
