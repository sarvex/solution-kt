class Solution {
  private var p: Map<Int, Int>? = null
  private var size: Map<Int, Int>? = null
  private var mx = 0
  private var n = 0
  fun groupStrings(words: Array<String>): IntArray {
    p = HashMap()
    size = HashMap()
    n = words.size
    mx = 0
    for (word in words) {
      var x = 0
      for (c in word.toCharArray()) {
        x = x or (1 shl c.code - 'a'.code)
      }
      p.put(x, x)
      size.put(x, size.getOrDefault(x, 0) + 1)
      mx = Math.max(mx, size.get(x)!!)
      if (size.get(x)!! > 1) {
        --n
      }
    }
    for (x in p.keySet()) {
      for (i in 0..25) {
        union(x, x xor (1 shl i))
        if (x shr i and 1 != 0) {
          for (j in 0..25) {
            if (x shr j and 1 == 0) {
              union(x, x xor (1 shl i) or (1 shl j))
            }
          }
        }
      }
    }
    return intArrayOf(n, mx)
  }

  private fun find(x: Int): Int {
    if (p!![x] !== x) {
      p.put(x, find(p!![x]!!))
    }
    return p!![x]!!
  }

  private fun union(a: Int, b: Int) {
    if (!p!!.containsKey(b)) {
      return
    }
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return
    }
    p.put(pa, pb)
    size.put(pb, size!![pb]!! + size!![pa]!!)
    mx = Math.max(mx, size!![pb]!!)
    --n
  }
}
