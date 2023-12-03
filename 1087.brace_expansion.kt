internal class Solution {
  private var ans: List<String>? = null
  private var items: List<Array<String>>? = null
  fun expand(s: String): Array<String> {
    ans = ArrayList()
    items = ArrayList()
    convert(s)
    dfs(0, ArrayList())
    Collections.sort(ans)
    return ans.toArray(arrayOfNulls<String>(0))
  }

  private fun convert(s: String) {
    if ("" == s) {
      return
    }
    if (s[0] == '{') {
      val j = s.indexOf("}")
      items.add(s.substring(1, j).split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
      convert(s.substring(j + 1))
    } else {
      val j = s.indexOf("{")
      if (j != -1) {
        items.add(s.substring(0, j).split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        convert(s.substring(j))
      } else {
        items.add(s.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
      }
    }
  }

  private fun dfs(i: Int, t: List<String>) {
    if (i == items!!.size()) {
      ans.add(java.lang.String.join("", t))
      return
    }
    for (c in items!![i]) {
      t.add(c)
      dfs(i + 1, t)
      t.remove(t.size() - 1)
    }
  }
}
