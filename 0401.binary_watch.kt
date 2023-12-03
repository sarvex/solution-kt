internal class Solution {
  fun readBinaryWatch(turnedOn: Int): List<String> {
    val ans: List<String> = ArrayList()
    for (i in 0..11) {
      for (j in 0..59) {
        if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
          ans.add(String.format("%d:%02d", i, j))
        }
      }
    }
    return ans
  }
}
