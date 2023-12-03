class ZeroEvenOdd(private val n: Int) {
  private val z: Semaphore = Semaphore(1)
  private val e: Semaphore = Semaphore(0)
  private val o: Semaphore = Semaphore(0)

  // printNumber.accept(x) outputs "x", where x is an integer.
  @Throws(InterruptedException::class)
  fun zero(printNumber: IntConsumer) {
    for (i in 0 until n) {
      z.acquire(1)
      printNumber.accept(0)
      if (i % 2 == 0) {
        o.release(1)
      } else {
        e.release(1)
      }
    }
  }

  @Throws(InterruptedException::class)
  fun even(printNumber: IntConsumer) {
    var i = 2
    while (i <= n) {
      e.acquire(1)
      printNumber.accept(i)
      z.release(1)
      i += 2
    }
  }

  @Throws(InterruptedException::class)
  fun odd(printNumber: IntConsumer) {
    var i = 1
    while (i <= n) {
      o.acquire(1)
      printNumber.accept(i)
      z.release(1)
      i += 2
    }
  }
}
