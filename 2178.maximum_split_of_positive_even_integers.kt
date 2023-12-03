class Solution {
  fun maximumEvenSplit(finalSum: Long): List<Long> {
    var finalSum = finalSum
    val ans: List<Long> = ArrayList()
    if (finalSum % 2 == 1L) {
      return ans
    }
    var i: Long = 2
    while (i <= finalSum) {
      ans.add(i)
      finalSum -= i
      i += 2
    }
    ans.add(ans.remove(ans.size() - 1) + finalSum)
    return ans
  }
}
