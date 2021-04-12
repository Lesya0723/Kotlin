import java.lang.Character.getNumericValue as getNumericValue1
import java.io.*;
fun sum3(input:String): Int{

        var cnt = 0

        for (c in input) {
            val i:Int = getNumericValue1(c)
            if (i % 3 == 0) {
                cnt += i
            }
        }
        return cnt
    }

    fun main8_3(args: Array<String>) {
        println("Введите число")
        val a : String? = readLine()
        if(a!=null){
            print(sum3(a.toString()))
        }
    }
