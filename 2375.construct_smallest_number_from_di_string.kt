java.util.Locale
import kotlin.jvm.JvmOverloads
import java.math.BigIntegerinternal

class Solution {
  private val vis = BooleanArray(10)
  private val t = StringBuilder()
  private var p: String? = null
  private var ans: String? = null
  fun smallestNumber(pattern: String?): String? {
    p = pattern
    dfs(0)
    return ans
  }

  private fun dfs(u: Int) {
    if (ans != null) {
      return
    }
    if (u == p!!.length + 1) {
      ans = t.toString()
      return
    }
    for (i in 1..9) {
      if (!vis[i]) {
        if (u > 0 && p!![u - 1] == 'I' && t[u - 1].code - '0'.code >= i) {
          continue
        }
        if (u > 0 && p!![u - 1] == 'D' && t[u - 1].code - '0'.code <= i) {
          continue
        }
        vis[i] = true
        t.append(i)
        dfs(u + 1)
        t.deleteCharAt(t.length - 1)
        vis[i] = false
      }
    }
  }
}
