package all.stage.myapplication

/**
 * Created by Hamza on 01/10/2017.
 */
var ListOfCarteSelected = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13)
var nbrOfRound = 1
var nbcounterRoundPlyer1=0
var nbcounterRoundPlyer2=0


fun buNumberEvent(ivSelect: Int): Int {


    var buClickValue: Int = 0
    when (ivSelect) {
        R.drawable.trefle_01, R.drawable.coeur_01, R.drawable.carreau_01, R.drawable.pick_01 -> {
            buClickValue = 1
        }
        R.drawable.trefle_02, R.drawable.coeur_02, R.drawable.carreau_02, R.drawable.pique_02 -> {
            buClickValue = 2
        }
        R.drawable.trefle__03, R.drawable.coeur_03, R.drawable.carreau_03, R.drawable.pique_03 -> {
            buClickValue = 3
        }
        R.drawable.trefle_04, R.drawable.coeur_04, R.drawable.carreau_04, R.drawable.pique_04 -> {
            buClickValue = 4
        }
        R.drawable.trefle_05, R.drawable.coeur_05, R.drawable.carreau_05, R.drawable.pique_05 -> {
            buClickValue = 5
        }
        R.drawable.trefle_06, R.drawable.coeur_06, R.drawable.carreau_06, R.drawable.pique_06 -> {
            buClickValue = 6
        }
        R.drawable.trefle_07, R.drawable.coeur_07, R.drawable.carreau_07, R.drawable.pique_07 -> {
            buClickValue = 7
        }
        R.drawable.trefle_08, R.drawable.coeur_08, R.drawable.carreau_08, R.drawable.pique_08 -> {
            buClickValue = 8
        }
        R.drawable.trefle_09, R.drawable.coeur_09, R.drawable.carreau_09, R.drawable.pique_09 -> {
            buClickValue = 9
        }
        R.drawable.trefle_10, R.drawable.coeur_10, R.drawable.carreau_10, R.drawable.pique_10 -> {
            buClickValue = 10
        }
        R.drawable.trefle_11, R.drawable.coeur_11, R.drawable.carreau_11, R.drawable.pique_11 -> {
            buClickValue = 11
        }
        R.drawable.trefle_12, R.drawable.coeur_12, R.drawable.carreau_12, R.drawable.pique_12 -> {
            buClickValue = 12
        }
        R.drawable.trefle_13, R.drawable.coeur_13, R.drawable.carreau_13, R.drawable.pique_13 -> {
            buClickValue = 13
        }
    }
    return buClickValue
}

fun printArrayWithMsg(arrayContent: IntArray, arrayName: String) {
    for (i in 0..arrayContent.size - 1) {
        println("$arrayName[$i] = ${arrayContent[i]}")
    }
}

fun printArrayListWithMsg(arrayContent: ArrayList<Int>, arrayName: String) {
    for (i in 0..arrayContent.size - 1) {
        println("$arrayName[$i] = ${arrayContent[i]}")
    }
}

fun emptyImageFromListCheked(checked: IntArray): Int {
    var output = -1
    for (i in 0..checked.size - 1) {
        if (checked[i] == 0) {
            output = i
            break
        }
    }
    return output
}

//Quatre cartes identiques
fun verifyQuads(number1: IntArray, indice1: IntArray): Boolean {
    var test = false
    if (number1[indice1[0]] == number1[indice1[1]] && number1[indice1[1]] == number1[indice1[2]] && number1[indice1[2]] == number1[indice1[3]]) {
        test = true
    }
    return test
}

fun isAnyEmptyImage(checked1: IntArray): Boolean {
    var output = false
    for (i in 0..checked1.size - 1) {
        if (checked1[i] == 0) {
            output = true
            break
        }
    }
    return output
}

//add the number of cheked carte turn all my code fail hhhhhhhhh
fun isCompleted(checked1: IntArray): Boolean {
    var test = true
    for (i in 0..checked1.size - 2) {
        if (checked1[i] != 1) {
            test = false
            break
        }
    }
    return test
}

fun resetArrayOfInt(checked1: IntArray) {
    for (i in 0..checked1.size - 1) {
        checked1[i] = 0
    }
}