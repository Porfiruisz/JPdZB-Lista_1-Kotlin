package com.example.probio_lista1

/**
 *@author Stanisław Wojtków
 *
 * Funkcja zwraca kolejne liczby w ciągu Collatza w zależności od argumentu wejściowego
 *
 * @param c parametr
 * @return lista kolejnych wartości w ciągu Collatza
 *
 * @throws IllegalArgumentException jeśli c jest ujemne, bądź równe 0
 */

/*
ŹRÓDŁA:

Przed przystąpieniem do ćwiczenia zbadałem zasadę działania ciągu collatza opierając się na kodzie C++ podanym w poniższym linku:

https://programmerabroad.com/collatz-sequence-in-cpp/
 */

fun collatz(c: Int): List<Int> {
    require(c > 0) { "Liczba musi byc dodatnia" } //Jeśli wprowadzony argument nie będzie liczbą dodatinią to otrzymamy wyjątek

    val sekwencja = mutableListOf(c)
    var cur = c
    while (cur != 1) {             //Pętla wykonuje się dopóki c nie będzie równa 1
        cur = if (cur % 2 == 0) { // C/2 jeśli liczba w ciągu jest podzielna przez 2
            cur / 2
        } else {                 // Reszta przypadków, czyli gdy liczba jest nieparzysta
            3 * cur + 1
        }
        sekwencja.add(cur)
    }
    return sekwencja
}

fun main(){

    //wywołania funkcji collatz

    val test1 = collatz(10) //poprawne wywołanie funkcji

    val test2 = collatz(0) //funkcja zwróci wyjątek "Liczba początkowa musi byc dodatnia"

    val test3 = collatz(-9) //funkcja zwróci wyjątek "Liczba początkowa musi byc dodatnia"

}