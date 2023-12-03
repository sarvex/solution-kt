class Solution {
  fun robotWithString(s: String): String {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    val ans = StringBuilder()
    val stk: Deque<Char> = ArrayDeque()
    var mi = 'a'
    for (c in s.toCharArray()) {
      --cnt[c.code - 'a'.code]
      while (mi < 'z' && cnt[mi.code - 'a'.code] == 0) {
        ++mi
      }
      stk.push(c)
      while (!stk.isEmpty() && stk.peek() <= mi) {
        ans.append(stk.pop())
      }
    }
    return ans.toString()
  }
}
