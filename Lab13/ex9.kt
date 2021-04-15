    fun main()
{println("Введите число\n")
    val x = readLine()!!.toInt()
    println("Что сделать с введенным числом?\n")
    println("1-Найти сумму цифр числа\n" +
            "2-найти максимальную цифру числа \n" +
            "3-Найти минимальную цифру числа \n" +
            "4-Найти произведение цифр числа \n" +
            "5-Найти количество чисел,взаимно простых с заданным \n" +
            "6-Найти сумму цифр числа,делящихся на 3 \n" +
            "7-Найти делитель числа ,являющийся взаимно простым с наибольшим количеством цифр данного числа\n")
    val p = readLine()!!.toInt()
    if (p != null) {
        when(p)
        {
            1 ->  print(ex7sum(x.toString()))
            2 ->  print(ex7max(x.toString()))
            3 -> print(ex7min(x.toString()))
            4   ->print(ex7pr(x.toString()))
            5->  println(kolVzProstNumb1(x))
            6 -> print(sum3(x.toString()))
            7 -> println(findDel(x))
            else -> println("Ошибка\n")
        }
    }
