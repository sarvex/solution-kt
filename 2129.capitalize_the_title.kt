import java.util.*

internal class Solution {
  fun capitalizeTitle(title: String): String {
    val ans: List<String> = ArrayList()
    for (s in title.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      if (s.length < 3) {
        ans.add(s.lowercase(Locale.getDefault()))
      } else {
        ans.add(s.substring(0, 1).uppercase(Locale.getDefault()) + s.substring(1).lowercase(Locale.getDefault()))
      }
    }
    return java.lang.String.join(" ", ans)
  }
}
