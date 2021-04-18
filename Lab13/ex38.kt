class p038 () {
    fun run(): String {
        var max = -1
        for (n in 2..9) {
            for (i in 1 until Math.pow(10.0, (9 / n).toDouble()).toInt()) {
                var concat = ""
                for (j in 1..n) concat += i * j
                if (isPandigital(concat)) max = Math.max(concat.toInt(), max)
            }
        }
        return Integer.toString(max)
    }}



    private fun isPandigital(concat: String): Boolean {
        if (concat.length != 9) return false
        val temp = concat.toCharArray()
        Arrays.sort(temp)
        return String(temp) == "123456789"
    }


       fun main() {
            println(p038().run())

    }
