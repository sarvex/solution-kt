class Solution {
  fun sortEvenOdd(nums: IntArray): IntArray {
    val n = nums.size
    val a = IntArray(n + 1 shr 1)
    val b = IntArray(n shr 1)
    run {
      var i = 0
      var j = 0
      while (j < n shr 1) {
        a[j] = nums[i]
        b[j] = nums[i + 1]
        i += 2
        ++j
      }
    }
    if (n % 2 == 1) {
      a[a.size - 1] = nums[n - 1]
    }
    Arrays.sort(a)
    Arrays.sort(b)
    val ans = IntArray(n)
    run {
      var i = 0
      var j = 0
      while (j < a.size) {
        ans[i] = a[j]
        i += 2
        ++j
      }
    }
    var i = 1
    var j = b.size - 1
    while (j >= 0) {
      ans[i] = b[j]
      i += 2
      --j
    }
    return ans
  }
}
