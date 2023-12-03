internal class Solution {
  private var i = 0
  private var expr: String? = null
  private val scope: Map<String, Deque<Int>> = HashMap()
  fun evaluate(expression: String?): Int {
    expr = expression
    return eval()
  }

  private fun eval(): Int {
    var c = expr!![i]
    if (c != '(') {
      return if (Character.isLowerCase(c)) scope[parseVar()].peekLast() else parseInt()
    }
    ++i
    c = expr!![i]
    var ans = 0
    if (c == 'l') {
      i += 4
      val vars: List<String> = ArrayList()
      while (true) {
        val `var` = parseVar()
        if (expr!![i] == ')') {
          ans = scope[`var`].peekLast()
          break
        }
        vars.add(`var`)
        ++i
        scope.computeIfAbsent(`var`) { k -> ArrayDeque() }.offer(eval())
        ++i
        if (!Character.isLowerCase(expr!![i])) {
          ans = eval()
          break
        }
      }
      for (v in vars) {
        scope[v].pollLast()
      }
    } else {
      val add = c == 'a'
      i += if (add) 4 else 5
      val a = eval()
      ++i
      val b = eval()
      ans = if (add) a + b else a * b
    }
    ++i
    return ans
  }

  private fun parseVar(): String {
    val j = i
    while (i < expr!!.length && expr!![i] != ' ' && expr!![i] != ')') {
      ++i
    }
    return expr!!.substring(j, i)
  }

  private fun parseInt(): Int {
    var sign = 1
    if (expr!![i] == '-') {
      sign = -1
      ++i
    }
    var v = 0
    while (i < expr!!.length && Character.isDigit(expr!![i])) {
      v = v * 10 + (expr!![i].code - '0'.code)
      ++i
    }
    return sign * v
  }
}
