internal class Solution {
  private val ans: List<Int> = ArrayList()
  private var num: String? = null
  fun splitIntoFibonacci(num: String?): List<Int> {
    this.num = num
    dfs(0)
    return ans
  }

  private fun dfs(i: Int): Boolean {
    if (i == num!!.length) {
      return ans.size() >= 3
    }
    var x: Long = 0
    for (j in i until num!!.length) {
      if (j > i && num!![i] == '0') {
        break
      }
      x = x * 10 + num!![j].code.toLong() - '0'.code.toLong()
      if (x > Int.MAX_VALUE || ans.size() >= 2 && x > ans[ans.size() - 1] + ans[ans.size() - 2]) {
        break
      }
      if (ans.size() < 2 || x == ans[ans.size() - 1] + ans[ans.size() - 2]) {
        ans.add(x.toInt())
        if (dfs(j + 1)) {
          return true
        }
        ans.remove(ans.size() - 1)
      }
    }
    return false
  }
}
