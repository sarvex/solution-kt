/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {
  private var i = 0
  private var nums: List<String>? = null
  private val inf = 1 shl 30

  // Encodes a tree to a single string.
  fun serialize(root: TreeNode?): String {
    nums = ArrayList()
    dfs(root)
    return java.lang.String.join(" ", nums)
  }

  // Decodes your encoded data to tree.
  fun deserialize(data: String?): TreeNode? {
    if (data == null || "" == data) {
      return null
    }
    i = 0
    nums = Arrays.asList(data.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
    return dfs(-inf, inf)
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    nums.add(java.lang.String.valueOf(root.`val`))
    dfs(root.left)
    dfs(root.right)
  }

  private fun dfs(mi: Int, mx: Int): TreeNode? {
    if (i == nums!!.size()) {
      return null
    }
    val x = nums!![i].toInt()
    if (x < mi || x > mx) {
      return null
    }
    val root = TreeNode(x)
    ++i
    root.left = dfs(mi, x)
    root.right = dfs(x, mx)
    return root
  }
}
