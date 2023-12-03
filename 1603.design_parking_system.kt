class ParkingSystem(big: Int, medium: Int, small: Int) {
  private val cnt: IntArray

  init {
    cnt = intArrayOf(0, big, medium, small)
  }

  fun addCar(carType: Int): Boolean {
    if (cnt[carType] == 0) {
      return false
    }
    --cnt[carType]
    return true
  }
}
