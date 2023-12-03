class Solution {
  fun checkIfPangram(sentence: String): Boolean {
    var mask = 0
    for (i in 0 until sentence.length) {
      mask = mask or (1 shl sentence[i].code - 'a'.code)
    }
    return mask == (1 shl 26) - 1
  }
}
