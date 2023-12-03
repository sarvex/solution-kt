internal class Solution {
  fun topKFrequent(nums: IntArray?, k: Int): IntArray {
    val frequency: Map<Int, Long> = Arrays.stream(nums).boxed().collect(
      Collectors.groupingBy(Function.identity(), Collectors.counting())
    )
    val queue: Queue<Map.Entry<Int, Long>> = PriorityQueue(Map.Entry.comparingByValue())
    for (entry in frequency.entrySet()) {
      queue.offer(entry)
      if (queue.size() > k) {
        queue.poll()
      }
    }
    return queue.stream().mapToInt(Map.Entry::getKey).toArray()
  }
}
