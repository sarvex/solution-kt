class Solution {
  fun halvesAreAlike(s: String): Boolean {
    var cnt = 0
    val n = s.length shr 1
    for (i in 0 until n) {
      cnt += if (Solution.Companion.VOWELS.contains(s[i])) 1 else 0
      cnt -= if (Solution.Companion.VOWELS.contains(s[i + n])) 1 else 0
    }
    return cnt == 0
  }

  companion object {
    private val VOWELS: Set<Char> = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
  }
}
