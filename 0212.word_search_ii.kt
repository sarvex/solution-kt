internal class Trie {
  var children = arrayOfNulls<Trie>(26)
  @JvmField
  var ref = -1
  fun insert(w: String, ref: Int) {
    var node = this
    for (i in 0 until w.length) {
      val j = w[i].code - 'a'.code
      if (node.children[j] == null) {
        node.children[j] = Trie()
      }
      node = node.children[j]!!
    }
    node.ref = ref
  }
}

internal class Solution {
  private var board: Array<CharArray>
  private var words: Array<String>
  private val ans: List<String> = ArrayList()
  fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    this.board = board
    this.words = words
    val tree = Trie()
    for (i in words.indices) {
      tree.insert(words[i], i)
    }
    val m = board.size
    val n = board[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        dfs(tree, i, j)
      }
    }
    return ans
  }

  private fun dfs(node: Trie, i: Int, j: Int) {
    var node = node
    val idx = board[i][j].code - 'a'.code
    if (node.children[idx] == null) {
      return
    }
    node = node.children[idx]!!
    if (node.ref != -1) {
      ans.add(words[node.ref])
      node.ref = -1
    }
    val c = board[i][j]
    board[i][j] = '#'
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < board.size && y >= 0 && y < board[0].size && board[x][y] != '#') {
        dfs(node, x, y)
      }
    }
    board[i][j] = c
  }
}
