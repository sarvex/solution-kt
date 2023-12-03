class CombinationIterator(characters: String, combinationLength: Int) {
  private var curr: Int
  private val size: Int
  private val cs: CharArray

  init {
    val n = characters.length
    curr = (1 shl n) - 1
    size = combinationLength
    cs = CharArray(n)
    for (i in 0 until n) {
      cs[i] = characters[n - i - 1]
    }
  }

  operator fun next(): String {
    while (curr >= 0 && Integer.bitCount(curr) != size) {
      --curr
    }
    val ans = StringBuilder()
    for (i in cs.indices) {
      if (curr shr i and 1 == 1) {
        ans.append(cs[i])
      }
    }
    --curr
    return ans.reverse().toString()
  }

  operator fun hasNext(): Boolean {
    while (curr >= 0 && Integer.bitCount(curr) != size) {
      --curr
    }
    return curr >= 0
  }
}
