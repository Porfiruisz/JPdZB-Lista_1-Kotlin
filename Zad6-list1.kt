package com.example.probio_lista1

/**
* @author Stanisław Wojtków
*
* Funkcja komplement dla sekwencji DNA znajduje i zwraca sekwencję nici matrycowej, natomiast funkcja transkrybuj znajduje i zwraca sekwencję RNA.
*
* @param dna wejściowa sekwencja DNA
* @return komplementarna sekwencja fragmentu DNA (od "ATG" do kodonu stop)
*
* @throws IllegalArgumentException jeśli dane wejściowe nie posiadają kodonu startowego "ATG"
* @throws IllegalArgumentException jeśli nie znaleciono kodonu stop TAA, TAG lub TGA
* @throws IllegalArgumentException jeśli nie znaleciono niepoprawne elementy w ciągu DNA
*/

/*
ŹRÓDŁA:

https://zpe.gov.pl/a/kod-genetyczny/D3KXAHRVz

https://en.wikipedia.org/wiki/DNA_and_RNA_codon_tables
 */

fun komplement(dna: String): String {
    val komplementy = mapOf(    //Stworzenie mapy dla poszczególnych fragmentów DNA
        'A' to 'T',
        'T' to 'A',
        'C' to 'G',
        'G' to 'C'
    )

    val startIndex = dna.indexOf("ATG") // Znalezienie kodonu startowego ATG
    if (startIndex == -1) {
        throw IllegalArgumentException("Brak kodonu startowego ATG w sekwencji DNA") // Jeśli takowego kodonu nie ma to funkcja zwraca wyjątek
    }

    val stopCodons = listOf("TAA", "TAG", "TGA") // Szukanie kodonu stop TAA, TAG lub TGA
    var endIndex = dna.length
    for (codon in stopCodons) {
        val stopIndex = dna.indexOf(codon, startIndex + 3)
        if (stopIndex != -1 && stopIndex < endIndex) {
            endIndex = stopIndex
        }
    }

    if (endIndex == dna.length) { // Sprawdzenie, czy znaleziono kodon stop
        throw IllegalArgumentException("Brak kodonu stop w sekwencji DNA") // Jeśli nie ma kodonu stop funkcja zwraca wyjątek
    }

    val subDna = dna.substring(startIndex, endIndex) //DNA pomiędzy kodonem startu a stopem

    return subDna.map { komplementy[it] ?: throw IllegalArgumentException("Nieprawidlowy znak w sekwencji DNA: $it") }.joinToString("") // Jeśli w ciągu DNA znajduje się nieprawidłowa wartość funkcja zwraca wyjątek
}


fun transkrybuj(dna: String): String{
    return dna.replace('A','U')
}

fun main(){

    val test1 = komplement("CATGGGCTGATTTGAA") //Prawidłowe wywołanie funkcji komplement
    println(test1)
    val test11 = transkrybuj(test1) //Prawidłowe wywołanie funkcji transkrybuj
    println(test11)

    val test2 = komplement("GGCTGATTT") //Otrzymujemy wyjątek "Brak kodonu startowego AUG w sekwencji DNA"

    val test3 = komplement("ATGGGCGTTT") //Otrzymujemy wyjątek "Brak kodonu stop w sekwencji DNA"

    val tesr4 = komplement("CATGGGCTQATTTGAA")  //Otrzymujemy wyjątek "Nieprawidlowy znak w sekwencji DNA: Q"

}