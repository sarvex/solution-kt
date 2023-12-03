import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun decodeString(s: String): String {
    val s1: Deque<Int> = ArrayDeque()
    val s2: Deque<String> = ArrayDeque()
    var num = 0
    var res = ""
    for (c in s.toCharArray()) {
      if ('0' <= c && c <= '9') {
        num = num * 10 + c.code - '0'.code
      } else if (c == '[') {
        s1.push(num)
        s2.push(res)
        num = 0
        res = ""
      } else if (c == ']') {
        val t = StringBuilder()
        var i = 0
        val n = s1.pop()
        while (i < n) {
          t.append(res)
          ++i
        }
        res = s2.pop() + t.toString()
      } else {
        res += c.toString()
      }
    }
    return res
  }
}
