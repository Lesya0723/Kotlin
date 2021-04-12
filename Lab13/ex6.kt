fun ex6(input:String): Int{
    var sum= 0

    for (c in input) {
        val i:Int = getNumericValue1(c)
        sum += i
    }
    return sum
}

fun main(args: Array<String>) {
    println("Введите число")
    val a : String? = readLine()
    if(a!=null){
        print(ex6(a.toString()))
    }
}
