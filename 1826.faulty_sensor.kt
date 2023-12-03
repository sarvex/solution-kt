class Solution {
  fun badSensor(sensor1: IntArray, sensor2: IntArray): Int {
    var i = 0
    val n = sensor1.size
    while (i < n - 1 && sensor1[i] == sensor2[i]) {
      ++i
    }
    while (i < n - 1) {
      if (sensor1[i + 1] != sensor2[i]) {
        return 1
      }
      if (sensor1[i] != sensor2[i + 1]) {
        return 2
      }
      ++i
    }
    return -1
  }
}
