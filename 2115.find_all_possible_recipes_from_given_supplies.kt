internal class Solution {
  fun findAllRecipes(
    recipes: Array<String?>, ingredients: List<List<String?>>, supplies: Array<String?>
  ): List<String> {
    val g: Map<String, List<String>> = HashMap()
    val indeg: Map<String, Int> = HashMap()
    for (i in recipes.indices) {
      for (v in ingredients[i]) {
        g.computeIfAbsent(v) { k -> ArrayList() }.add(recipes[i])
      }
      indeg.put(recipes[i], ingredients[i].size())
    }
    val q: Deque<String> = ArrayDeque()
    for (s in supplies) {
      q.offer(s)
    }
    val ans: List<String> = ArrayList()
    while (!q.isEmpty()) {
      for (n in q.size() downTo 1) {
        val i: String = q.pollFirst()
        for (j in g[i] ?: Collections.emptyList()) {
          indeg.put(j, indeg[j]!! - 1)
          if (indeg[j] === 0) {
            ans.add(j)
            q.offer(j)
          }
        }
      }
    }
    return ans
  }
}
