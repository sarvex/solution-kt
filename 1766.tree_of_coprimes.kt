import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

class Solution {
  private var g: Array<List<Int>?>
  private var f: Array<List<Int>?>
  private var stks: Array<Deque<IntArray>?>
  private var nums: IntArray
  private var ans: IntArray
  fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
    val n = nums.size
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    f = arrayOfNulls(51)
    stks = arrayOfNulls(51)
    Arrays.setAll(f) { k -> ArrayList() }
    Arrays.setAll(stks) { k -> ArrayDeque() }
    for (i in 1..50) {
      for (j in 1..50) {
        if (gcd(i, j) == 1) {
          f[i].add(j)
        }
      }
    }
    this.nums = nums
    ans = IntArray(n)
    dfs(0, -1, 0)
    return ans
  }

  private fun dfs(i: Int, fa: Int, depth: Int) {
    var t = -1
    var k = -1
    for (v in f[nums[i]]!!) {
      val stk = stks[v]
      if (!stk!!.isEmpty() && stk.peek()[1] > k) {
        t = stk.peek()[0]
        k = stk.peek()[1]
      }
    }
    ans[i] = t
    for (j in g[i]!!) {
      if (j != fa) {
        stks[nums[i]]!!.push(intArrayOf(i, depth))
        dfs(j, i, depth + 1)
        stks[nums[i]]!!.pop()
      }
    }
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
