fun main(args: Array<String>) {

        val p = ArrayList<Int>()
        p.add(1)
        var n = 0
        while (p[n] != 0) {
            var i = 0
            var pentagonal = 1
            p.add(0)
            n++
            while (pentagonal <= n) {
                val sign = if (i % 4 > 1) -1 else 1
                p[n] = p[n] + sign * p[n - pentagonal]
                p[n] = p[n] % 1000000
                i++
                val k = if (i % 2 == 0) i / 2 + 1 else -(i / 2 + 1) // 1, -1, 2, -2, ...
                pentagonal = k * (3 * k - 1) / 2
            }
        }
        println(n)
    }
