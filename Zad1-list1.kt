package com.example.probio_lista1

import kotlin.math.sqrt

/**
 * @author Stanisław Wojtków
 * Oblicza pole trójkąta przy użyciu wzoru Herona.
 *
 * @param a długość pierwszego boku (musi być dodatnia)
 * @param b długość drugiego boku (musi być dodatnia)
 * @param c długość trzeciego boku (musi być dodatnia)
 * @return pole powierzchni trójkąta jako liczba zmiennoprzecinkowa typu Double
 *
 * @throws IllegalArgumentException jeśli którykolwiek z boków jest niedodatni
 * @throws IllegalArgumentException jeśli suma dwóch boków nie jest większa niż trzeci bok (nie tworzy trójkąta)
 */


fun heron(a: Double, b: Double, c: Double): Double{
    require(a > 0 && b > 0 && c > 0) { "Dlugosci bokow musza byc dodatnie" } // wyjątek jeśli wprowadzone argumenty są mniejsze bądź równe zero
    require(a + b > c && a + c > b && b + c > a) { "Podane wartosci nie tworza trojkata" } // wyjątek jeśli suma dwóch boków jest mniejsza od trzeciego

    val q = (a+b+c)/2
    val P: Double = sqrt(q*(q-a)*(q-b)*(q-c))

    return P
}

fun main(){
    val testHeron1 = heron(3.0,4.0,5.0) //otrzymujemy poprawną wartość
    println(testHeron1)

    val testHeron2 = heron(-3.0,4.0,5.0) //otrzymujemy wyjątek "Dlugosci bokow musza byc dodatnie"
    println(testHeron2)

    val testHeron = heron(30.0,4.0,5.0) //otrzymujemy wyjątek "Podane wartosci nie tworza trojkata"
    println(testHeron)
}
