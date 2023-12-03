internal class Solution {
  fun simplifyPath(path: String): String {
    val stk: Deque<String> = ArrayDeque()
    for (s in path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      if ("" == s || "." == s) {
        continue
      }
      if (".." == s) {
        stk.pollLast()
      } else {
        stk.offerLast(s)
      }
    }
    return "/" + java.lang.String.join("/", stk)
  }
}
