fun op(s: Char): (Int, Int) -> Int = when (s) {
    '+' -> {a: Int, b: Int -> a + b}
    '-' -> {a: Int, b: Int -> a - b}
    '*' -> {a: Int, b: Int -> a * b}
    else -> throw IllegalArgumentException("Unknown operation")
}

fun main() 
    println(op('*')(10,15))
}
