internal class Solution {
  fun isValidSerialization(preorder: String): Boolean {
    val stk: List<String> = ArrayList()
    for (s in preorder.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      stk.add(s)
      while (stk.size() >= 3 && stk[stk.size() - 1].equals("#")
        && stk[stk.size() - 2].equals("#") && !stk[stk.size() - 3].equals("#")
      ) {
        stk.remove(stk.size() - 1)
        stk.remove(stk.size() - 1)
        stk.remove(stk.size() - 1)
        stk.add("#")
      }
    }
    return stk.size() === 1 && stk[0].equals("#")
  }
}
