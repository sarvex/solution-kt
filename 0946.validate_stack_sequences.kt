class Solution {
  fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stk: Deque<Int> = ArrayDeque()
    var j = 0
    for (v in pushed) {
      stk.push(v)
      while (!stk.isEmpty() && stk.peek() === popped[j]) {
        stk.pop()
        ++j
      }
    }
    return j == pushed.size
  }
}
