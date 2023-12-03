class Solution {
  fun fillCups(amount: IntArray): Int {
    Arrays.sort(amount)
    return if (amount[0] + amount[1] <= amount[2]) {
      amount[2]
    } else (amount[0] + amount[1] + amount[2] + 1) / 2
  }
}
