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
  // Encodes a tree to a single string.
  fun serialize(root: TreeNode?): String {
    if (root == null) {
      return ""
    }
    val sb = StringBuilder()
    preorder(root, sb)
    return sb.toString()
  }

  private fun preorder(root: TreeNode?, sb: StringBuilder) {
    if (root == null) {
      sb.append(NULL + SEP)
      return
    }
    sb.append(root.`val` + SEP)
    preorder(root.left, sb)
    preorder(root.right, sb)
  }

  // Decodes your encoded data to tree.
  fun deserialize(data: String?): TreeNode? {
    if (data == null || "" == data) {
      return null
    }
    val vals: List<String> = LinkedList()
    for (x in data.split(SEP.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      vals.add(x)
    }
    return deserialize(vals)
  }

  private fun deserialize(vals: List<String>): TreeNode? {
    val first: String = vals.remove(0)
    if (NULL == first) {
      return null
    }
    val root = TreeNode(first.toInt())
    root.left = deserialize(vals)
    root.right = deserialize(vals)
    return root
  }

  companion object {
    private const val NULL = "#"
    private const val SEP = ","
  }
}
