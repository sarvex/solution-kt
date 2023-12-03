internal class Solution {
  fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val cnt = IntArray(26)
    for (i in 0 until magazine.length) {
      ++cnt[magazine[i].code - 'a'.code]
    }
    for (i in 0 until ransomNote.length) {
      if (--cnt[ransomNote[i].code - 'a'.code] < 0) {
        return false
      }
    }
    return true
  }
}
