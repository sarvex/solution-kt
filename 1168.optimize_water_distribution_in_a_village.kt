internal class Solution {
  private var p: IntArray
  fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {
    var n = n
    val nums = Array(n + pipes.size) { IntArray(0) }
    var j = 0
    for (pipe in pipes) {
      nums[j++] = pipe
    }
    for (i in 0 until n) {
      nums[j++] = intArrayOf(0, i + 1, wells[i])
    }
    Arrays.sort(nums) { a, b -> a.get(2) - b.get(2) }
    p = IntArray(n + 1)
    for (i in 1..n) {
      p[i] = i
    }
    var ans = 0
    for (x in nums) {
      val pa = find(x[0])
      val pb = find(x[1])
      if (pa == pb) {
        continue
      }
      ans += x[2]
      p[pa] = pb
      if (--n == 0) {
        break
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
