fun main(args: Array<String>) {
    println("Введите имя пользователя")
    val name = readLine()
    if (name != null) {
            println("Hello,$name ")
        }
    println("Какой язык у вас самый любимый? Kotlin, Prolog,C, Java, Python,C#,C++, Php, Pascal или Ruby")
    val language = readLine()
    val kotlin  = "Kotlin"
    val prolog  = "Prolog"
    val c     = "C"
    val java  = "Java"
    val python  = "Python"
    val csharp  = "C#"
    val cplusplus  = "C++"
    val php    = "PHP"
    val pascal  = "Pascal"
    val ruby  = "Ruby"
    if (language != null) {
        when(language)
        {
            kotlin ->  println("Ты подлиза)\n")
            prolog ->  println("Ты подлиза)\n")
            c -> println("Ты староват\n")
            java   -> println("Ты начал с  нужного языка \n")
            python -> println("Ты современный\n")
            csharp -> println("Ты что-то можешь \n")
            cplusplus -> println("Ты первокурсник \n")
            php -> println("Ты web-designer\n")
            pascal -> println("Ты учишься в школе \n")
            ruby ->  println("Ты занимаешь веб-разработкой \n")
            else -> println("Введи правильно название языка\n")
        }
    }
}
