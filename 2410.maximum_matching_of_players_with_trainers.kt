class Solution {
  fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
    Arrays.sort(players)
    Arrays.sort(trainers)
    var ans = 0
    var j = 0
    for (p in players) {
      while (j < trainers.size && trainers[j] < p) {
        ++j
      }
      if (j < trainers.size) {
        ++ans
        ++j
      }
    }
    return ans
  }
}
