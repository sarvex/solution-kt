internal class Solution {
  fun calPoints(ops: Array<String>): Int {
    val stk: Deque<Int> = ArrayDeque()
    for (op in ops) {
      if ("+" == op) {
        val a: Int = stk.pop()
        val b: Int = stk.peek()
        stk.push(a)
        stk.push(a + b)
      } else if ("D" == op) {
        stk.push(stk.peek() shl 1)
      } else if ("C" == op) {
        stk.pop()
      } else {
        stk.push(op.toInt())
      }
    }
    return stk.stream().mapToInt(Integer::intValue).sum()
  }
}
