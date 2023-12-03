internal class Solution {
  private var n = 0
  private var g: Array<IntArray>
  private var res: Array<Array<IntArray>>
  private var degree: Array<Array<IntArray>>
  fun catMouseGame(graph: Array<IntArray>): Int {
    n = graph.size
    g = graph
    res = Array(n) { Array(n) { IntArray(2) } }
    degree = Array(n) { Array(n) { IntArray(2) } }
    for (i in 0 until n) {
      for (j in 1 until n) {
        degree[i][j][Solution.Companion.MOUSE_TURN] = g[i].size
        degree[i][j][Solution.Companion.CAT_TURN] = g[j].size
      }
    }
    for (i in 0 until n) {
      for (j in g[Solution.Companion.HOLE]) {
        --degree[i][j][Solution.Companion.CAT_TURN]
      }
    }
    val q: Deque<IntArray> = ArrayDeque()
    for (j in 1 until n) {
      res[0][j][Solution.Companion.MOUSE_TURN] = Solution.Companion.MOUSE_WIN
      res[0][j][Solution.Companion.CAT_TURN] = Solution.Companion.MOUSE_WIN
      q.offer(intArrayOf(0, j, Solution.Companion.MOUSE_TURN))
      q.offer(intArrayOf(0, j, Solution.Companion.CAT_TURN))
    }
    for (i in 1 until n) {
      res[i][i][Solution.Companion.MOUSE_TURN] = Solution.Companion.CAT_WIN
      res[i][i][Solution.Companion.CAT_TURN] = Solution.Companion.CAT_WIN
      q.offer(intArrayOf(i, i, Solution.Companion.MOUSE_TURN))
      q.offer(intArrayOf(i, i, Solution.Companion.CAT_TURN))
    }
    while (!q.isEmpty()) {
      val state: IntArray = q.poll()
      val t = res[state[0]][state[1]][state[2]]
      val prevStates = getPrevStates(state)
      for (prevState in prevStates) {
        val pm = prevState[0]
        val pc = prevState[1]
        val pt = prevState[2]
        if (res[pm][pc][pt] == Solution.Companion.TIE) {
          val win =
            t == Solution.Companion.MOUSE_WIN && pt == Solution.Companion.MOUSE_TURN || t == Solution.Companion.CAT_WIN && pt == Solution.Companion.CAT_TURN
          if (win) {
            res[pm][pc][pt] = t
            q.offer(prevState)
          } else {
            if (--degree[pm][pc][pt] == 0) {
              res[pm][pc][pt] = t
              q.offer(prevState)
            }
          }
        }
      }
    }
    return res[Solution.Companion.MOUSE_START][Solution.Companion.CAT_START][Solution.Companion.MOUSE_TURN]
  }

  private fun getPrevStates(state: IntArray): List<IntArray> {
    val pre: List<IntArray> = ArrayList()
    val m = state[0]
    val c = state[1]
    val t = state[2]
    val pt = t xor 1
    if (pt == Solution.Companion.CAT_TURN) {
      for (pc in g[c]) {
        if (pc != Solution.Companion.HOLE) {
          pre.add(intArrayOf(m, pc, pt))
        }
      }
    } else {
      for (pm in g[m]) {
        pre.add(intArrayOf(pm, c, pt))
      }
    }
    return pre
  }

  companion object {
    private const val HOLE = 0
    private const val MOUSE_START = 1
    private const val CAT_START = 2
    private const val MOUSE_TURN = 0
    private const val CAT_TURN = 1
    private const val MOUSE_WIN = 1
    private const val CAT_WIN = 2
    private const val TIE = 0
  }
}
