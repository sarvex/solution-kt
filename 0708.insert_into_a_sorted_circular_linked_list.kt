internal class Solution {
  fun insert(head: Node?, insertVal: Int): Node {
    val node = Node(insertVal)
    if (head == null) {
      node.next = node
      return node
    }
    var prev = head
    var curr = head.next
    while (curr !== head) {
      if (prev!!.`val` <= insertVal && insertVal <= curr!!.`val` || prev.`val` > curr!!.`val` && (insertVal >= prev.`val` || insertVal <= curr.`val`)) {
        break
      }
      prev = curr
      curr = curr.next
    }
    prev!!.next = node
    node.next = curr
    return head
  }
}
