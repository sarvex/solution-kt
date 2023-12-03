internal class Solution {
  fun findEvenNumbers(digits: IntArray): IntArray {
    val counter = count(digits)
    val ans: List<Int> = ArrayList()
    var i = 100
    while (i < 1000) {
      val t = IntArray(3)
      var j = 0
      var k = i
      while (k > 0) {
        t[j] = k % 10
        k /= 10
        ++j
      }
      val cnt = count(t)
      if (check(counter, cnt)) {
        ans.add(i)
      }
      i += 2
    }
    return ans.stream().mapToInt(Integer::valueOf).toArray()
  }

  private fun check(cnt1: IntArray, cnt2: IntArray): Boolean {
    for (i in 0..9) {
      if (cnt1[i] < cnt2[i]) {
        return false
      }
    }
    return true
  }

  private fun count(nums: IntArray): IntArray {
    val counter = IntArray(10)
    for (num in nums) {
      ++counter[num]
    }
    return counter
  }
}
