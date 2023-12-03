internal class Solution {
  fun generatePossibleNextMoves(currentState: String): List<String> {
    val cs = currentState.toCharArray()
    val ans: List<String> = ArrayList()
    for (i in 0 until cs.size - 1) {
      if (cs[i] == '+' && cs[i + 1] == '+') {
        cs[i] = '-'
        cs[i + 1] = '-'
        ans.add(String(cs))
        cs[i] = '+'
        cs[i + 1] = '+'
      }
    }
    return ans
  }
}
