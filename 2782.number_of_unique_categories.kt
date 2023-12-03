/**
 * Definition for a category handler.
 * class CategoryHandler {
 * public CategoryHandler(int[] categories);
 * public boolean haveSameCategory(int a, int b);
 * };
 */
internal class Solution {
  private var p: IntArray
  fun numberOfCategories(n: Int, categoryHandler: CategoryHandler): Int {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (a in 0 until n) {
      for (b in a + 1 until n) {
        if (categoryHandler.haveSameCategory(a, b)) {
          p[find(a)] = find(b)
        }
      }
    }
    var ans = 0
    for (i in 0 until n) {
      if (i == p[i]) {
        ++ans
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
