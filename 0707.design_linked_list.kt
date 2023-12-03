internal class MyLinkedList {
  private val dummy: ListNode = ListNode()
  private var cnt = 0
  operator fun get(index: Int): Int {
    var index = index
    if (index < 0 || index >= cnt) {
      return -1
    }
    var cur: Unit = dummy.next
    while (index-- > 0) {
      cur = cur.next
    }
    return cur.`val`
  }

  fun addAtHead(`val`: Int) {
    addAtIndex(0, `val`)
  }

  fun addAtTail(`val`: Int) {
    addAtIndex(cnt, `val`)
  }

  fun addAtIndex(index: Int, `val`: Int) {
    var index = index
    if (index > cnt) {
      return
    }
    var pre: ListNode = dummy
    while (index-- > 0) {
      pre = pre.next
    }
    pre.next = ListNode(`val`, pre.next)
    ++cnt
  }

  fun deleteAtIndex(index: Int) {
    var index = index
    if (index < 0 || index >= cnt) {
      return
    }
    var pre: ListNode = dummy
    while (index-- > 0) {
      pre = pre.next
    }
    val t: Unit = pre.next
    pre.next = t.next
    t.next = null
    --cnt
  }
}
