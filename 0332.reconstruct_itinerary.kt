internal class Solution {
  fun dfs(adjLists: Map<String?, Queue<String?>?>, ans: List<String?>, curr: String?) {
    val neighbors: Queue<String?>? = adjLists[curr]
    if (neighbors == null) {
      ans.add(curr)
      return
    }
    while (!neighbors.isEmpty()) {
      val neighbor: String = neighbors.poll()
      dfs(adjLists, ans, neighbor)
    }
    ans.add(curr)
    return
  }

  fun findItinerary(tickets: List<List<String?>>): List<String> {
    val adjLists: Map<String?, Queue<String?>> = HashMap()
    for (ticket in tickets) {
      val from = ticket[0]
      val to = ticket[1]
      if (!adjLists.containsKey(from)) {
        adjLists.put(from, PriorityQueue())
      }
      adjLists[from].add(to)
    }
    val ans: List<String> = ArrayList()
    dfs(adjLists, ans, "JFK")
    Collections.reverse(ans)
    return ans
  }
}
