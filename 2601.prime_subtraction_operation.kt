class Solution {
  fun primeSubOperation(nums: IntArray): Boolean {
    val p: List<Int> = ArrayList()
    for (i in 2..1000) {
      var ok = true
      for (j in p) {
        if (i % j == 0) {
          ok = false
          break
        }
      }
      if (ok) {
        p.add(i)
      }
    }
    val n = nums.size
    for (i in n - 2 downTo 0) {
      if (nums[i] < nums[i + 1]) {
        continue
      }
      val j = search(p, nums[i] - nums[i + 1])
      if (j == p.size() || p[j] >= nums[i]) {
        return false
      }
      nums[i] -= p[j]
    }
    return true
  }

  private fun search(nums: List<Int>, x: Int): Int {
    var l = 0
    var r: Int = nums.size()
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
