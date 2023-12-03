import kotlin.math.max

internal class Trie {
  var children = arrayOfNulls<Trie>(128)
  var isEnd = false
  fun insert(word: String) {
    var node = this
    for (c in word.toCharArray()) {
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]!!
    }
    node.isEnd = true
  }
}

internal class Solution {
  fun addBoldTag(s: String, words: Array<String?>): String {
    val trie = Trie()
    for (w in words) {
      trie.insert(w!!)
    }
    val pairs: List<IntArray> = ArrayList()
    val n = s.length
    for (i in 0 until n) {
      var node = trie
      for (j in i until n) {
        val idx = s[j].code
        if (node.children[idx] == null) {
          break
        }
        node = node.children[idx]!!
        if (node.isEnd) {
          pairs.add(intArrayOf(i, j))
        }
      }
    }
    if (pairs.isEmpty()) {
      return s
    }
    val t: List<IntArray> = ArrayList()
    var st = pairs[0][0]
    var ed = pairs[0][1]
    for (j in 1 until pairs.size()) {
      val a = pairs[j][0]
      val b = pairs[j][1]
      if (ed + 1 < a) {
        t.add(intArrayOf(st, ed))
        st = a
        ed = b
      } else {
        ed = max(ed.toDouble(), b.toDouble()).toInt()
      }
    }
    t.add(intArrayOf(st, ed))
    var i = 0
    var j = 0
    val ans = StringBuilder()
    while (i < n) {
      if (j == t.size()) {
        ans.append(s.substring(i))
        break
      }
      st = t[j][0]
      ed = t[j][1]
      if (i < st) {
        ans.append(s.substring(i, st))
      }
      ++j
      ans.append("<b>")
      ans.append(s.substring(st, ed + 1))
      ans.append("</b>")
      i = ed + 1
    }
    return ans.toString()
  }
}
