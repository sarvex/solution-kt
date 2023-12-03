import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.max

internal class Solution {
  fun lengthLongestPath(input: String): Int {
    var i = 0
    val n = input.length
    var ans = 0
    val stack: Deque<Int> = ArrayDeque()
    while (i < n) {
      var ident = 0
      while (input[i] == '\t') {
        ident++
        i++
      }
      var cur = 0
      var isFile = false
      while (i < n && input[i] != '\n') {
        cur++
        if (input[i] == '.') {
          isFile = true
        }
        i++
      }
      i++

      // popd
      while (!stack.isEmpty() && stack.size() > ident) {
        stack.pop()
      }
      if (stack.size() > 0) {
        cur += stack.peek() + 1
      }

      // pushd
      if (!isFile) {
        stack.push(cur)
        continue
      }
      ans = max(ans.toDouble(), cur.toDouble()).toInt()
    }
    return ans
  }
}
