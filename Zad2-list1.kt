package com.example.probio_lista1

/**
 * Zwraca listę elementów wspólnych dla dwóch multizbiorów, uwzględniając liczbę wystąpień. Funkcja przyjmuje listę elementów dowolnego typu.
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
}