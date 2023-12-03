class Solution {
  fun reorderLogFiles(logs: Array<String>): Array<String> {
    Arrays.sort(logs) { a: String, b: String -> cmp(a, b) }
    return logs
  }

  private fun cmp(a: String, b: String): Int {
    val t1 = a.split(" ".toRegex(), limit = 2).toTypedArray()
    val t2 = b.split(" ".toRegex(), limit = 2).toTypedArray()
    val d1 = Character.isDigit(t1[1][0])
    val d2 = Character.isDigit(t2[1][0])
    if (!d1 && !d2) {
      val v = t1[1].compareTo(t2[1])
      return if (v == 0) t1[0].compareTo(t2[0]) else v
    }
    if (d1 && d2) {
      return 0
    }
    return if (d1) 1 else -1
  }
}
