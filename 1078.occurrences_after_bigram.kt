internal class Solution {
  fun findOcurrences(text: String, first: String, second: String): Array<String> {
    val words = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val ans: List<String> = ArrayList()
    for (i in 0 until words.size - 2) {
      if (first == words[i] && second == words[i + 1]) {
        ans.add(words[i + 2])
      }
    }
    return ans.toArray(arrayOfNulls<String>(0))
  }
}
