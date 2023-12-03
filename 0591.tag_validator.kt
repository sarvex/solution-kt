internal class Solution {
  fun isValid(code: String): Boolean {
    val stk: Deque<String> = ArrayDeque()
    var i = 0
    while (i < code.length) {
      if (i > 0 && stk.isEmpty()) {
        return false
      }
      if (code.startsWith("<![CDATA[", i)) {
        i = code.indexOf("]]>", i + 9)
        if (i < 0) {
          return false
        }
        i += 2
      } else if (code.startsWith("</", i)) {
        val j = i + 2
        i = code.indexOf(">", j)
        if (i < 0) {
          return false
        }
        val t = code.substring(j, i)
        if (!check(t) || stk.isEmpty() || !stk.pop().equals(t)) {
          return false
        }
      } else if (code.startsWith("<", i)) {
        val j = i + 1
        i = code.indexOf(">", j)
        if (i < 0) {
          return false
        }
        val t = code.substring(j, i)
        if (!check(t)) {
          return false
        }
        stk.push(t)
      }
      ++i
    }
    return stk.isEmpty()
  }

  private fun check(tag: String): Boolean {
    val n = tag.length
    if (n < 1 || n > 9) {
      return false
    }
    for (c in tag.toCharArray()) {
      if (!Character.isUpperCase(c)) {
        return false
      }
    }
    return true
  }
}
