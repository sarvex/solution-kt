class Solution {
  fun minLength(s: String): Int {
    val stk: Deque<Char> = ArrayDeque()
    stk.push(' ')
    for (c in s.toCharArray()) {
      if (c == 'B' && stk.peek() === 'A' || c == 'D' && stk.peek() === 'C') {
        stk.pop()
      } else {
        stk.push(c)
      }
    }
    return stk.size() - 1
  }
}
