class Solution {
  fun countTexts(pressedKeys: String): Int {
    var ans: Long = 1
    var i = 0
    val n = pressedKeys.length
    while (i < n) {
      var j = i
      val c = pressedKeys[i]
      while (j + 1 < n && pressedKeys[j + 1] == c) {
        ++j
      }
      val cnt = j - i + 1
      ans = if (c == '7' || c == '9') ans * Solution.Companion.g.get(cnt) else ans * Solution.Companion.f.get(cnt)
      ans %= Solution.Companion.MOD.toLong()
      i = j
      ++i
    }
    return ans.toInt()
  }

  companion object {
    private const val N = 100010
    private const val MOD = 1e9.toInt() + 7
    private val f = LongArray(Solution.Companion.N)
    private val g = LongArray(Solution.Companion.N)

    init {
      Solution.Companion.f.get(0) = 1
      Solution.Companion.f.get(1) = 1
      Solution.Companion.f.get(2) = 2
      Solution.Companion.f.get(3) = 4
      Solution.Companion.g.get(0) = 1
      Solution.Companion.g.get(1) = 1
      Solution.Companion.g.get(2) = 2
      Solution.Companion.g.get(3) = 4
      for (i in 4 until Solution.Companion.N) {
        Solution.Companion.f.get(i) =
          (Solution.Companion.f.get(i - 1) + Solution.Companion.f.get(i - 2) + Solution.Companion.f.get(i - 3)) % Solution.Companion.MOD
        Solution.Companion.g.get(i) =
          (Solution.Companion.g.get(i - 1) + Solution.Companion.g.get(i - 2) + Solution.Companion.g.get(i - 3) + Solution.Companion.g.get(
            i - 4
          )) % Solution.Companion.MOD
      }
    }
  }
}
