class Solution {
  fun maxRepeating(sequence: String, word: String): Int {
    for (k in sequence.length / word.length downTo 1) {
      if (sequence.contains(word.repeat(k))) {
        return k
      }
    }
    return 0
  }
}
