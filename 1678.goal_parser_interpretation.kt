class Solution {
  fun interpret(command: String): String {
    val ans = StringBuilder()
    for (i in 0 until command.length) {
      val c = command[i]
      if (c == 'G') {
        ans.append(c)
      } else if (c == '(') {
        ans.append(if (command[i + 1] == ')') "o" else "al")
      }
    }
    return ans.toString()
  }
}
