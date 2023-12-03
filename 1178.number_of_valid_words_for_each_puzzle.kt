internal class Solution {
  fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
    val cnt: Map<Int, Int> = HashMap(words.size)
    for (w in words) {
      var mask = 0
      for (i in 0 until w.length) {
        mask = mask or (1 shl w[i].code - 'a'.code)
      }
      cnt.merge(mask, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans: List<Int> = ArrayList()
    for (p in puzzles) {
      var mask = 0
      for (i in 0 until p.length) {
        mask = mask or (1 shl p[i].code - 'a'.code)
      }
      var x = 0
      val i = p[0].code - 'a'.code
      var j = mask
      while (j > 0) {
        if (j shr i and 1 == 1) {
          x += cnt[j] ?: 0
        }
        j = j - 1 and mask
      }
      ans.add(x)
    }
    return ans
  }
}
