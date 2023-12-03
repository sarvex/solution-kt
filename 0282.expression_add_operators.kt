internal class Solution {
  private var ans: List<String>? = null
  private var num: String? = null
  private var target = 0
  fun addOperators(num: String?, target: Int): List<String> {
    ans = ArrayList()
    this.num = num
    this.target = target
    dfs(0, 0, 0, "")
    return ans
  }

  private fun dfs(u: Int, prev: Long, curr: Long, path: String) {
    if (u == num!!.length) {
      if (curr == target.toLong()) ans.add(path)
      return
    }
    for (i in u until num!!.length) {
      if (i != u && num!![u] == '0') {
        break
      }
      val next = num!!.substring(u, i + 1).toLong()
      if (u == 0) {
        dfs(i + 1, next, next, path + next)
      } else {
        dfs(i + 1, next, curr + next, "$path+$next")
        dfs(i + 1, -next, curr - next, "$path-$next")
        dfs(i + 1, prev * next, curr - prev + prev * next, "$path*$next")
      }
    }
  }
}
