import kotlin.math.max

class Solution {
  private var p: IntArray
  fun gcdSort(nums: IntArray): Boolean {
    val n = 100010
    p = IntArray(n)
    val f: Map<Int, List<Int>> = HashMap()
    for (i in 0 until n) {
      p[i] = i
    }
    var mx = 0
    for (num in nums) {
      mx = max(mx.toDouble(), num.toDouble()).toInt()
    }
    for (i in 2..mx) {
      if (f.containsKey(i)) {
        continue
      }
      var j = i
      while (j <= mx) {
        f.computeIfAbsent(j) { k -> ArrayList() }.add(i)
        j += i
      }
    }
    for (i in nums) {
      for (j in f[i]!!) {
        p[find(i)] = find(j)
      }
    }
    val s = IntArray(nums.size)
    System.arraycopy(nums, 0, s, 0, nums.size)
    Arrays.sort(s)
    for (i in nums.indices) {
      if (s[i] != nums[i] && find(nums[i]) != find(s[i])) {
        return false
      }
    }
    return true
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
