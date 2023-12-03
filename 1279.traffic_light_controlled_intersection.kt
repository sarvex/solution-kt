class TrafficLight {
  private var road = 1
  @Synchronized
  fun carArrived(
    carId: Int,  // ID of the car
    roadId: Int,  // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
    direction: Int,  // Direction of the car
    turnGreen: Runnable,  // Use turnGreen.run() to turn light to green on current road
    crossCar: Runnable // Use crossCar.run() to make car cross the intersection
  ) {
    if (roadId != road) {
      turnGreen.run()
      road = roadId
    }
    crossCar.run()
  }
}
