class FizzBuzz(private val n: Int) {
  private val fSema: Semaphore = Semaphore(0)
  private val bSema: Semaphore = Semaphore(0)
  private val fbSema: Semaphore = Semaphore(0)
  private val nSema: Semaphore = Semaphore(1)

  // printFizz.run() outputs "fizz".
  @Throws(InterruptedException::class)
  fun fizz(printFizz: Runnable) {
    var i = 3
    while (i <= n) {
      if (i % 5 != 0) {
        fSema.acquire()
        printFizz.run()
        nSema.release()
      }
      i = i + 3
    }
  }

  // printBuzz.run() outputs "buzz".
  @Throws(InterruptedException::class)
  fun buzz(printBuzz: Runnable) {
    var i = 5
    while (i <= n) {
      if (i % 3 != 0) {
        bSema.acquire()
        printBuzz.run()
        nSema.release()
      }
      i = i + 5
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  @Throws(InterruptedException::class)
  fun fizzbuzz(printFizzBuzz: Runnable) {
    var i = 15
    while (i <= n) {
      fbSema.acquire()
      printFizzBuzz.run()
      nSema.release()
      i = i + 15
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  @Throws(InterruptedException::class)
  fun number(printNumber: IntConsumer) {
    for (i in 1..n) {
      nSema.acquire()
      if (i % 3 == 0 && i % 5 == 0) {
        fbSema.release()
      } else if (i % 3 == 0) {
        fSema.release()
      } else if (i % 5 == 0) {
        bSema.release()
      } else {
        printNumber.accept(i)
        nSema.release()
      }
    }
  }
}
