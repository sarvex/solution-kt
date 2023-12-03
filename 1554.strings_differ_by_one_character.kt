class Solution {
  fun differByOne(dict: Array<String>): Boolean {
    val s: Set<String> = HashSet()
    for (word in dict) {
      for (i in 0 until word.length) {
        val t = word.substring(0, i) + "*" + word.substring(i + 1)
        if (s.contains(t)) {
          return true
        }
        s.add(t)
      }
    }
    return false
  }
}
