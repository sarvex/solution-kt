internal class Solution {
  fun palindromePairs(words: Array<String>): List<List<Int>> {
    val n = words.size
    val prefix = LongArray(n)
    val suffix = LongArray(n)
    for (i in 0 until n) {
      val word = words[i]
      val m = word.length
      for (j in 0 until m) {
        val t = word[j].code - 'a'.code + 1
        val s = word[m - j - 1].code - 'a'.code + 1
        prefix[i] = prefix[i] * Solution.Companion.BASE % Solution.Companion.MOD + t
        suffix[i] = suffix[i] * Solution.Companion.BASE % Solution.Companion.MOD + s
      }
    }
    val ans: List<List<Int>> = ArrayList()
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (check(i, j, words[j].length, words[i].length, prefix, suffix)) {
          ans.add(Arrays.asList(i, j))
        }
        if (check(j, i, words[i].length, words[j].length, prefix, suffix)) {
          ans.add(Arrays.asList(j, i))
        }
      }
    }
    return ans
  }

  private fun check(i: Int, j: Int, n: Int, m: Int, prefix: LongArray, suffix: LongArray): Boolean {
    val t: Long =
      (prefix[i] * Solution.Companion.MUL.get(n) % Solution.Companion.MOD + prefix[j]) % Solution.Companion.MOD
    val s: Long =
      (suffix[j] * Solution.Companion.MUL.get(m) % Solution.Companion.MOD + suffix[i]) % Solution.Companion.MOD
    return t == s
  }

  companion object {
    private const val BASE = 131
    private val MUL = LongArray(310)
    private const val MOD = 1e9.toInt() + 7

    init {
      Solution.Companion.MUL.get(0) = 1
      for (i in 1 until Solution.Companion.MUL.size) {
        Solution.Companion.MUL.get(i) =
          Solution.Companion.MUL.get(i - 1) * Solution.Companion.BASE % Solution.Companion.MOD
      }
    }
  }
}
