internal class UnionFind(n: Int) {
  private val p: IntArray
  private val size: IntArray

  init {
    p = IntArray(n)
    size = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa != pb) {
      if (size[pa] > size[pb]) {
        p[pb] = pa
        size[pa] += size[pb]
      } else {
        p[pa] = pb
        size[pb] += size[pa]
      }
    }
  }
}

internal class Solution {
  private val ans: List<String> = ArrayList()
  private val t: List<String> = ArrayList()
  private var words: List<String>? = null
  private var d: Map<String?, Int>? = null
  private var uf: UnionFind? = null
  private var g: Array<List<Int>?>
  private var sentence: Array<String>
  fun generateSentences(synonyms: List<List<String?>>, text: String): List<String> {
    val ss: Set<String> = HashSet()
    for (pairs in synonyms) {
      ss.addAll(pairs)
    }
    words = ArrayList(ss)
    val n: Int = words.size()
    d = HashMap(n)
    for (i in 0 until words.size()) {
      d.put(words.get(i), i)
    }
    uf = UnionFind(n)
    for (pairs in synonyms) {
      uf!!.union(d.get(pairs[0])!!, d.get(pairs[1])!!)
    }
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      g[uf!!.find(i)].add(i)
    }
    for (e in g) {
      e.sort { i, j -> words.get(i).compareTo(words.get(j)) }
    }
    sentence = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= sentence.size) {
      ans.add(java.lang.String.join(" ", t))
      return
    }
    if (!d!!.containsKey(sentence[i])) {
      t.add(sentence[i])
      dfs(i + 1)
      t.remove(t.size() - 1)
    } else {
      for (j in g[uf!!.find(d!![sentence[i]]!!)]!!) {
        t.add(words!![j])
        dfs(i + 1)
        t.remove(t.size() - 1)
      }
    }
  }
}
