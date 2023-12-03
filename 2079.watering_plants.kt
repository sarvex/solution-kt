class Solution {
  fun wateringPlants(plants: IntArray, capacity: Int): Int {
    var ans = 0
    var cap = capacity
    for (i in plants.indices) {
      if (cap >= plants[i]) {
        cap -= plants[i]
        ++ans
      } else {
        ans += i * 2 + 1
        cap = capacity - plants[i]
      }
    }
    return ans
  }
}
