package com.example.probio_lista1

/**
 *@author Stanisław Wojtków
 *
 * Funkcja zwraca listę pierwszych `n` elementów ciągu Fibonacciego.
 *
 * @param n liczba elementów do wygenerowania
 * @return lista liczb Fibonacciego o długości `n`
 *
 * @throws IllegalArgumentException jeśli n jest ujemne
 */

fun Fibonacci(n: Int): List<Int> {
    require(n >= 0) { "Wartosc n nie moze byc mniejsza od 0" } // Funkcja zwraca wyjątek gdy argument jest mniejszy od 0

    if (n == 0) return listOf(0) //Gdy za argument zostanie podane 0, w konsoli wyświetli się tylko [0]

    val wynik = mutableListOf(0, 1)

    for (i in 2 until n) {
        wynik.add(wynik[i - 1] + wynik[i - 2])
    }

    return wynik
}


// Tą funkcję dodałem po terminie. Nie doczytałem polecenia na eportalu
fun FibonacciRek(n: Int): List<Int> {
    return if (n <= 1) n else FibonacciRek(n-1)+FibonacciRek(n-2)
}

fun main(){
    val test1 = Fibonacci(10) //Poprawne wywołanie funkcji
    println(test1)

    val test2 = Fibonacci(0) //Poprawne wywołanie funkcji (w konsoli otrzymamy [0])
    println(test2)

    val test3 = Fibonacci(1) //Poprawne wywołanie funkcji (w konsoli otrzymamy [1])
    println(test3)

    val test4 = Fibonacci(-10) //Błędne wywołanie funkcji (w konsoli otrzymamy komunikat błędu "Wartosc n nie moze byz mniejsza od 0" )
    println(test4)
}
