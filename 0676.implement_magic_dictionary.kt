internal class MagicDictionary
/** Initialize your data structure here.  */
{
  private val s: Set<String> = HashSet()
  private val cnt: Map<String, Int> = HashMap()
  fun buildDict(dictionary: Array<String>) {
    for (word in dictionary) {
      s.add(word)
      for (p in gen(word)) {
        cnt.put(p, (cnt[p] ?: 0) + 1)
      }
    }
  }

  fun search(searchWord: String): Boolean {
    for (p in gen(searchWord)) {
      val v = cnt[p] ?: 0
      if (v > 1 || v == 1 && !s.contains(searchWord)) {
        return true
      }
    }
    return false
  }

  private fun gen(word: String): List<String> {
    val res: List<String> = ArrayList()
    val chars = word.toCharArray()
    for (i in chars.indices) {
      val c = chars[i]
      chars[i] = '*'
      res.add(String(chars))
      chars[i] = c
    }
    return res
  }
}
