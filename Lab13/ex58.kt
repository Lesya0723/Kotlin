  fun main() {
        var primes = 0
        var s = 1
        while ((if (primes == 0) 1 else primes) * 10 >= 2 * s - 1) {
            for (i in 1..3) {
                if (isPrime(s * s - i * (s - 1))) {
                    primes++
                }
            }
            s += 2
        }
        println(s)
    }

    fun isPrime(n: Int): Boolean {
        if (n == 2) {
            return true
        }
        if (n == 1 || n % 2 == 0) {
            return false
        }
        var i = 3
        while (i * i <= n) {
            if (n % i == 0) {
                return false
            }
            i += 2
        }
        return true
    }
