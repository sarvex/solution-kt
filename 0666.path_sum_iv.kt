internal class Solution {
  private var ans = 0
  private var mp: Map<Int, Int>? = null
  fun pathSum(nums: IntArray): Int {
    ans = 0
    mp = HashMap(nums.size)
    for (num in nums) {
      mp.put(num / 10, num % 10)
    }
    dfs(11, 0)
    return ans
  }

  private fun dfs(node: Int, t: Int) {
    var t = t
    if (!mp!!.containsKey(node)) {
      return
    }
    t += mp!![node]!!
    val d = node / 10
    val p = node % 10
    val l = (d + 1) * 10 + p * 2 - 1
    val r = l + 1
    if (!mp!!.containsKey(l) && !mp!!.containsKey(r)) {
      ans += t
      return
    }
    dfs(l, t)
    dfs(r, t)
  }
}
