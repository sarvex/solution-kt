internal class Solution {
  fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val ans = IntArray(n)
    val stk: Deque<Int> = ArrayDeque()
    var curr = -1
    for (log in logs) {
      val t = log.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      var fid = t[0].toInt()
      val ts = t[2].toInt()
      if ("start" == t[1]) {
        if (!stk.isEmpty()) {
          ans[stk.peek()] += ts - curr
        }
        stk.push(fid)
        curr = ts
      } else {
        fid = stk.pop()
        ans[fid] += ts - curr + 1
        curr = ts + 1
      }
    }
    return ans
  }
}
