class Solution {
  fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
    val n = aliceValues.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(aliceValues[i] + bobValues[i], i)
    }
    Arrays.sort(arr) { a, b -> b.get(0) - a.get(0) }
    var a = 0
    var b = 0
    for (i in 0 until n) {
      val j = arr[i][1]
      if (i % 2 == 0) {
        a += aliceValues[j]
      } else {
        b += bobValues[j]
      }
    }
    if (a == b) {
      return 0
    }
    return if (a > b) 1 else -1
  }
}
