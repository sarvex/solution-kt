import java.util.*

internal class Solution {
  fun toHexspeak(num: String): String {
    val t = java.lang.Long.toHexString(num.toLong()).uppercase(Locale.getDefault()).replace("0", "O").replace("1", "I")
    for (c in t.toCharArray()) {
      if (!Solution.Companion.S.contains(c)) {
        return "ERROR"
      }
    }
    return t
  }

  companion object {
    private val S: Set<Char> = Set.of('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O')
  }
}
