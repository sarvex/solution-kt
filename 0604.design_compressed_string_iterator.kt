internal class StringIterator(compressedString: String) {
  private val d: List<Node> = ArrayList()
  private var p = 0

  init {
    val n = compressedString.length
    var i = 0
    while (i < n) {
      val c = compressedString[i]
      var x = 0
      while (++i < n && Character.isDigit(compressedString[i])) {
        x = x * 10 + (compressedString[i].code - '0'.code)
      }
      d.add(Node(c.code, x))
    }
  }

  operator fun next(): Char {
    if (!hasNext()) {
      return ' '
    }
    val ans: Char = d[p].c
    if (--d[p].x === 0) {
      ++p
    }
    return ans
  }

  operator fun hasNext(): Boolean {
    return p < d.size() && d[p].x > 0
  }
}

internal open class Node(@JvmField var c: Char, @JvmField var x: Int)
