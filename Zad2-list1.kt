package com.example.probio_lista1

/**
 * Zwraca listę elementów wspólnych dla dwóch multizbiorów. Funkcja przyjmuje listę elementów dowolnego typu.
 *
 * @author Stanisław Wojtków
 *
 * @param x pierwszy multizbiór
 * @param y drugi multizbiór
 * @return lista elementów wspólnych
 *
 * @throws IllegalArgumentException jeśli którakolwiek z list jest pusta
 */

fun <T> wspolne(x: List<T>, y: List<T>): List<T> {
    require(x.isNotEmpty()) { "Multizbior nie moze byc pusty" }
    require(y.isNotEmpty()) { "Multizbior nie moze byc pusty" }

    val mapaX = x.groupingBy { it }.eachCount()
    val mapaY = y.groupingBy { it }.eachCount()

    return mapaX.keys.intersect(mapaY.keys).flatMap { key -> List(minOf(mapaX.getValue(key), mapaY.getValue(key))) { key }} // ten fragment został stworzony z pomocą chatu GPT
}

fun main(){

    val multizbior1 = listOf(1, 2, 2, 2, 4, 4, 5, 6)
    val multizbior2 = listOf(2, 2, 3, 4, 4, 4, 6, 6)
    val wynik = wspolne(multizbior1, multizbior2)
    println(wynik) //Poprawne wywołanie funkcji

    val multizbior3 = listOf("A", "A", "B", "C", "C", "C", "D", "E")
    val multizbior4 = listOf("A", "A", "A", "C", "C", "D", "D", "E")
    val wynik2 = wspolne(multizbior3, multizbior4)
    println(wynik2) //Poprawne wywołanie funkcji

    val multizbior5 = listOf(1,1,1,1,1)
    val multizbior6 = listOf(0)
    val wynik3 = wspolne(multizbior5, multizbior6)
    println(wynik3) //Poprawne wywołanie funkcji (funkcja zwróciła pusty zbiór)
}
