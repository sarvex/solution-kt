class Solution {
  fun filterRestaurants(
    restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int
  ): List<Int> {
    Arrays.sort(restaurants) { a, b -> if (a.get(1) === b.get(1)) b.get(0) - a.get(0) else b.get(1) - a.get(1) }
    val ans: List<Int> = ArrayList()
    for (r in restaurants) {
      if (r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance) {
        ans.add(r[0])
      }
    }
    return ans
  }
}
