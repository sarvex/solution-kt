class Solution {
  fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    val list: List<IntArray> = ArrayList()
    dfs(root, 0, 0, list)
    list.sort(object : Comparator<IntArray?>() {
      fun compare(o1: IntArray, o2: IntArray): Int {
        if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0])
        return if (o1[1] != o2[1]) Integer.compare(o2[1], o1[1]) else Integer.compare(o1[2], o2[2])
      }
    })
    val res: List<List<Int>> = ArrayList()
    var preX = 1
    for (cur in list) {
      if (preX != cur[0]) {
        res.add(ArrayList())
        preX = cur[0]
      }
      res[res.size() - 1].add(cur[2])
    }
    return res
  }

  private fun dfs(root: TreeNode?, x: Int, y: Int, list: List<IntArray>) {
    if (root == null) {
      return
    }
    list.add(intArrayOf(x, y, root.`val`))
    dfs(root.left, x - 1, y - 1, list)
    dfs(root.right, x + 1, y - 1, list)
  }
}
