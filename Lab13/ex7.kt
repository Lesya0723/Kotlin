import java.lang.Character.getNumericValue as getNumericValue1
fun ex7sum(input:String): Int{

    var sum = 0
    for (c in input) {
        val i:Int = getNumericValue1(c)
        sum += i
    }
    return sum

}
fun ex7max(input:String): Int{

    var max = 0

    for (c in input) {
        val i:Int = getNumericValue1(c)
        if(i> max)
        {
            max=i
        }
    }
    return max
}
fun ex7min(input:String): Int{
    var min = 10

    for (c in input) {
        val i:Int = getNumericValue1(c)
        if(i< min)
        {
            min=i
        }


    }
    return min
}
fun ex7pr(input:String): Int{
    var pr=1

    for (c in input) {
        val i:Int = getNumericValue1(c)

            pr*=i
    }

    return pr
}

fun main() {
    println("Введите число")
    val a : String? = readLine()
    if(a!=null){
        print("\nСумма цифр\n")
        print(ex7sum(a.toString()))
        print("\nМаксимальная цифра\n")
        print(ex7max(a.toString()))
        print("\nМинимальная цифра\n")
        print(ex7min(a.toString()))
        print("\nПроизведение цифр\n")
        print(ex7pr(a.toString()))
    }
}
