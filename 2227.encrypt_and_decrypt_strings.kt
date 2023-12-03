class Encrypter(keys: CharArray, values: Array<String?>, dictionary: Array<String>) {
  private val mp: Map<Char, String> = HashMap()
  private val cnt: Map<String, Int> = HashMap()

  init {
    for (i in keys.indices) {
      mp.put(keys[i], values[i])
    }
    for (w in dictionary) {
      w = encrypt(w)
      cnt.put(w, (cnt[w] ?: 0) + 1)
    }
  }

  fun encrypt(word1: String): String {
    val sb = StringBuilder()
    for (c in word1.toCharArray()) {
      if (!mp.containsKey(c)) {
        return ""
      }
      sb.append(mp[c])
    }
    return sb.toString()
  }

  fun decrypt(word2: String): Int {
    return cnt[word2] ?: 0
  }
}
