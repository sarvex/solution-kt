internal class Solution {
  fun smallestSubsequence(text: String): String {
    val cnt = IntArray(26)
    for (c in text.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    val vis = BooleanArray(26)
    val cs = CharArray(text.length)
    var top = -1
    for (c in text.toCharArray()) {
      --cnt[c.code - 'a'.code]
      if (!vis[c.code - 'a'.code]) {
        while (top >= 0 && c < cs[top] && cnt[cs[top].code - 'a'.code] > 0) {
          vis[cs[top--].code - 'a'.code] = false
        }
        cs[++top] = c
        vis[c.code - 'a'.code] = true
      }
    }
    return String(cs, 0, top + 1)
  }
}
