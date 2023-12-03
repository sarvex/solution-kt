internal class Solution {
  fun maxChunksToSorted(arr: IntArray): Int {
    val stk: Deque<Int> = ArrayDeque()
    for (v in arr) {
      if (stk.isEmpty() || stk.peek() <= v) {
        stk.push(v)
      } else {
        val mx: Int = stk.pop()
        while (!stk.isEmpty() && stk.peek() > v) {
          stk.pop()
        }
        stk.push(mx)
      }
    }
    return stk.size()
  }
}
