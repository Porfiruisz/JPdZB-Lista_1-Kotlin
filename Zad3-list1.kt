package com.example.probio_lista1
import kotlin.math.pow
/**
 * Funkcja zwraca listę podzbiorów zbioru wejściowego
 *
 * @author Stanisław Wojtków
 *
 * @param zbior zbiór elementów dowolnego typu
 * @return lista wszystkich podzbiorów zbioru wejściowego
 *
 * @throws IllegalArgumentException jeśli zbiór jest pusty
 * @throws IllegalArgumentException jeśli zbiór zawiera nieprawidłowy element
 */


fun <T> podzbiory(zbior: Set<T>): List<Set<T>> {
    require(zbior.isNotEmpty()) { "Zbior nie moze byc pusty" }

    if (zbior.any { it is String && it.isEmpty() }) {
        throw IllegalArgumentException("Zbior zawiera nieprawidlowy element") // Wyjątek, gdy funkcja zawiera pusty element ciągu (np. " ")
    }

    val lista = zbior.toList()
    val n = lista.size
    val wynik = mutableListOf<Set<T>>()
    val dwa = 2.0

    for (i in 1 until dwa.pow(n).toInt()) {  // dwa.pow(n).toInt(), czyli wszystkie kombinacje 2^n
        val podzbior = mutableSetOf<T>()
        for (j in 0 until n) {
            if (i and (dwa.pow(j).toInt()) != 0) {
                podzbior.add(lista[j])
            }
        }
        wynik.add(podzbior)
    }

    return wynik
}



fun main(){

    //Funkcja działa nieco "chaotycznie", ale nie mogłem wymyśleć niczego lepszego

    val test1 = setOf('A','B','C') //Poprawne wywołanie funkcji
    println(podzbiory(test1))

    val test2 = setOf("") // Funkcja zwraca wyjątek
    println(podzbiory(test2))

    val test3 = setOf('1','2',3) //Poprawne wywołanie funkcji (nawet nie mając jednego z argumentów w apostrofach)
    println(podzbiory(test3))

    val test4 = setOf('1','A',3) //Poprawne wywołanie funkcji
    println(podzbiory(test4))

}
