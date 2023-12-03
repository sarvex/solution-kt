internal class LFUCache(private val capacity: Int) {
  private val map: Map<Int, Node>
  private val freqMap: Map<Int, DoublyLinkedList>
  private var minFreq = 0

  init {
    map = HashMap(capacity, 1)
    freqMap = HashMap()
  }

  operator fun get(key: Int): Int {
    if (capacity == 0) {
      return -1
    }
    if (!map.containsKey(key)) {
      return -1
    }
    val node = map[key]
    incrFreq(node)
    return node!!.value
  }

  fun put(key: Int, value: Int) {
    if (capacity == 0) {
      return
    }
    if (map.containsKey(key)) {
      val node = map[key]
      node!!.value = value
      incrFreq(node)
      return
    }
    if (map.size() === capacity) {
      val list = freqMap[minFreq]
      map.remove(list!!.removeLast()!!.key)
    }
    val node = Node(key, value)
    addNode(node)
    map.put(key, node)
    minFreq = 1
  }

  private fun incrFreq(node: Node?) {
    val freq = node!!.freq
    val list = freqMap[freq]
    list!!.remove(node)
    if (list.isEmpty()) {
      freqMap.remove(freq)
      if (freq == minFreq) {
        minFreq++
      }
    }
    node.freq++
    addNode(node)
  }

  private fun addNode(node: Node?) {
    val freq = node!!.freq
    val list = freqMap[freq] ?: DoublyLinkedList()
    list.addFirst(node)
    freqMap.put(freq, list)
  }

  private class Node internal constructor(var key: Int, var value: Int) {
    var freq = 1
    var prev: Node? = null
    var next: Node? = null
  }

  private class DoublyLinkedList {
    private val head: Node
    private val tail: Node

    init {
      head = Node(-1, -1)
      tail = Node(-1, -1)
      head.next = tail
      tail.prev = head
    }

    fun addFirst(node: Node?) {
      node!!.prev = head
      node.next = head.next
      head.next!!.prev = node
      head.next = node
    }

    fun remove(node: Node?): Node? {
      node!!.next!!.prev = node.prev
      node.prev!!.next = node.next
      node.next = null
      node.prev = null
      return node
    }

    fun removeLast(): Node? {
      return remove(tail.prev)
    }

    val isEmpty: Boolean
      get() = head.next === tail
  }
}
