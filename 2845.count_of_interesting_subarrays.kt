class Solution {
  fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
    val n: Int = nums.size()
    val arr = IntArray(n)
    for (i in 0 until n) {
      arr[i] = if (nums[i] % modulo === k) 1 else 0
    }
    val cnt: Map<Int, Int> = HashMap()
    cnt.put(0, 1)
    var ans: Long = 0
    var s = 0
    for (x in arr) {
      s += x
      ans += cnt[(s - k + modulo) % modulo] ?: 0
      cnt.merge(s % modulo, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
