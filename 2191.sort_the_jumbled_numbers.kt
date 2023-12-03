class Solution {
  fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
    val n = nums.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      var x = nums[i]
      var y = if (x == 0) mapping[0] else 0
      var k = 1
      while (x > 0) {
        y += k * mapping[x % 10]
        k *= 10
        x /= 10
      }
      arr[i] = intArrayOf(y, i)
    }
    Arrays.sort(arr) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = nums[arr[i][1]]
    }
    return ans
  }
}
