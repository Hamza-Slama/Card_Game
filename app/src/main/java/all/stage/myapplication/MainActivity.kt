package all.stage.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*


class MainActivity : AppCompatActivity() {


    var ListOfCarte1_test = arrayListOf(R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01)
    var ListOfCarte = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13, R.drawable.trefle_01, R.drawable.trefle_02, R.drawable.trefle__03, R.drawable.trefle_04, R.drawable.trefle_05, R.drawable.trefle_06, R.drawable.trefle_07, R.drawable.trefle_08, R.drawable.trefle_09, R.drawable.trefle_10, R.drawable.trefle_11, R.drawable.trefle_12, R.drawable.trefle_13, R.drawable.coeur_01, R.drawable.coeur_02, R.drawable.coeur_03, R.drawable.coeur_04, R.drawable.coeur_05, R.drawable.coeur_06, R.drawable.coeur_07, R.drawable.coeur_08, R.drawable.coeur_09, R.drawable.coeur_10, R.drawable.coeur_11, R.drawable.coeur_12, R.drawable.coeur_13, R.drawable.pick_01, R.drawable.pique_02, R.drawable.pique_03, R.drawable.pique_04, R.drawable.pique_05, R.drawable.pique_06, R.drawable.pique_07, R.drawable.pique_08, R.drawable.pique_09, R.drawable.pique_10, R.drawable.pique_11, R.drawable.pique_12, R.drawable.pique_13)
    var ListOfCarteSelected = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13)

    var ConstantnumberOfCard = 52
    var number1 = IntArray(ConstantnumberOfCard)
    var number2 = IntArray(ConstantnumberOfCard)

    var listPlayer_1_Image = IntArray(ConstantnumberOfCard)
    var listPlayer_2_Image = IntArray(ConstantnumberOfCard)

    // indice for save the pos of image setted from the list of 52 carte
    var indice1 = IntArray(4)
    var indice2 = IntArray(4)

    // test of small list ,  the index 5 : is to save how carte is cheked
    var checked1 = IntArray(5) { 0 }
    var checked2 = IntArray(5) { 0 }
    //comment
    // to impose the dupplicated set carte
    var setted1 = IntArray(ConstantnumberOfCard) { 0 }
    var setted2 = IntArray(ConstantnumberOfCard) { 0 }

    var emptyPlaceFromTheListOfImage1 = IntArray(ConstantnumberOfCard) { 0 }
    var emptyPlaceFromTheListOfImage2 = IntArray(ConstantnumberOfCard) { 0 }


    //counter of carte in your main
    var counter = 26
    var counter2 = 26

    var listOfCarteInGame = ArrayList<Int>()


    // select carte number for palying
    var numberOfSelectedCarte = -1

    var testDestribute = false
    var isPressedSet = false

    var counterLastSetCarte = 0

    //player curently play
    var set1 = true
    var set2 = true


    var istrueListOfCarte = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        distributeRandomizeCarte()
        setImageCheked()
        turnImageToListOfCarte()
        setCarteSelectionOfGame()
        setCarteToCenter()
        isLiar()
//        findTheWinner()


    }

    fun distributeRandomizeCarte() {
        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1)
        var listPlayer_2 = arrayOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2)


        ivDistributed.setOnClickListener {
            if (!testDestribute) {
                testDestribute = true
                var randomi2 = 0
                var randomi = 0
                var i = 0
                while (i < 25) {
                    var rand = Random()
                    if (ListOfCarte.size != 0) {

                        randomi = rand.nextInt(ListOfCarte.size)
                        listPlayer_1[i].setImageResource(ListOfCarte[randomi])
                        number1[i] = buNumberEvent(ListOfCarte[randomi])
                        listPlayer_1_Image[i] = ListOfCarte[randomi]
                        emptyPlaceFromTheListOfImage1[i] = 1
                        ListOfCarte.removeAt(randomi)

                        randomi2 = rand.nextInt(ListOfCarte.size)
                        listPlayer_2[i].setImageResource(ListOfCarte[randomi2])
                        number2[i] = buNumberEvent(ListOfCarte[randomi2])
                        listPlayer_2_Image[i] = ListOfCarte[randomi2]
                        emptyPlaceFromTheListOfImage2[i] = 1
                        ListOfCarte.removeAt(randomi2)
                    }
                    i++
                }
                listPlayer_1[25].setImageResource(ListOfCarte.last())
                listPlayer_1_Image[25] = ListOfCarte.last()
                number1[25] = buNumberEvent(ListOfCarte.last())
                emptyPlaceFromTheListOfImage1[25] = 1
                listPlayer_2[25].setImageResource(ListOfCarte.first())
                listPlayer_2_Image[25] = ListOfCarte.first()
                number2[25] = buNumberEvent(ListOfCarte.first())
                emptyPlaceFromTheListOfImage2[25] = 1
            } else {
                Toast.makeText(this, "Heh Wait For The Next Round !   ", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun setImageCheked() {

        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1, iv27_Player1, iv28_Player1, iv29_Player1, iv30_Player1, iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1, iv37_Player1, iv38_Player1, iv39_Player1, iv40_Player1, iv41_Player1, iv42_Player1, iv43_Player1, iv44_Player1, iv45_Player1, iv46_Player1, iv47_Player1, iv48_Player1, iv49_Player1, iv50_Player1, iv51_Player1, iv52_Player1)
        var listPlayer_2 = arrayListOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2, iv27_Player2, iv28_Player2, iv29_Player2, iv30_Player2, iv31_Player2, iv32_Player2, iv33_Player2, iv34_Player2, iv35_Player2, iv36_Player2, iv37_Player2, iv38_Player2, iv39_Player2, iv40_Player2, iv41_Player2, iv42_Player2, iv43_Player2, iv44_Player2, iv45_Player2, iv46_Player2, iv47_Player2, iv48_Player2, iv49_Player2, iv50_Player2, iv51_Player2, iv52_Player2)

        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)
        println(testDestribute)

        // set the image for the player 1

        for (po in 0..listPlayer_1.size - 1) {

            listPlayer_1[po].setOnClickListener {

                if (testDestribute && setted1[po] == 0) {

                    // position must be here !
                    var position = emptyImageFromListCheked(checked1)

                    if (isAnyEmptyImage(checked1) && position < 4) {

                        counter--
                        setted1[po] = 1
                        emptyPlaceFromTheListOfImage1[po] = 0

                        txt_Player1_Counter.text = "${counter}"

//                         listPlayer_1_OutPut[position].visibility = View.VISIBLE
//                        println("listPlayer_1_Image[po] = ${listPlayer_1_Image[po]}")

                        listPlayer_1_OutPut[position].setImageResource(listPlayer_1_Image[po])
                        listPlayer_1[po].visibility = View.GONE

                        indice1[position] = po
                        checked1[position] = 1

                        checked1[4]++

//                        println("1er position = $position)")
//                        printCheked(checked1)
//                        println(po)
//                        printArrayWithMsg(listPlayer_1_Image, "listPlayer_1_Image")

                        listPlayer_1[po].setImageResource(0)


                    }

//                    println("novelle = $position)")
//                    println("isCompleted(checked1) = ${isCompleted(checked1)}")
//                    println("verifyQuads(number1, indice1) = ${verifyQuads(number1, indice1)}")

                    if (isCompleted(checked1)) {
                        if (verifyQuads(number1, indice1)) {
                            resetArrayOfInt(checked1)
                            val toast = Toast.makeText(this, "This is A quads ", Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.TOP, 10, 110)
                            toast.show()
                            Handler().postDelayed({
                                resetImageChosenByPlayer1()
                            }, 1400)
                        }
                    }
                }
            }
        }

        // set the image for the player 2

        for (po in 0..listPlayer_2.size - 1) {

            listPlayer_2[po].setOnClickListener {

                if (testDestribute && setted2[po] == 0) {

                    // position must be here !
                    var position = emptyImageFromListCheked(checked2)
                    if (isAnyEmptyImage(checked2) && position < 4) {

                        counter2--
                        txt_Player2_Counter.text = "${counter2}"

                        listPlayer_2_OutPut[position].setImageResource(listPlayer_2_Image[po])
                        listPlayer_2[po].visibility = View.GONE

                        indice2[position] = po
                        checked2[position] = 1
                        emptyPlaceFromTheListOfImage2[po] = 0
                        checked2[4]++
                        setted2[po] = 1

//                        println("1er position = $position)")
//                        printCheked(checked2)
                        listPlayer_2[po].setImageResource(0)

                    }
                    // il faut reinitilliser la position
//                    position = emptyImageFromListCheked(checked2)
//                    println("novelle = $position)")

//                    printverify()

                    if (isCompleted(checked2)) {

//                        printverify()

                        if (verifyQuads(number2, indice2)) {
                            resetArrayOfInt(checked2)
                            val toast = Toast.makeText(this, "This is A quads ", Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.BOTTOM, 10, 10)
                            toast.show()
                            Handler().postDelayed({
                                resetImageChosenByPlayer2()
                            }, 1400)
                        }
                    }
                }
            }
        }
    }


    fun turnImageToListOfCarte() {
        var test = false
        var test2 = false

        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1, iv27_Player1, iv28_Player1, iv29_Player1, iv30_Player1, iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1, iv37_Player1, iv38_Player1, iv39_Player1, iv40_Player1, iv41_Player1, iv42_Player1, iv43_Player1, iv44_Player1, iv45_Player1, iv46_Player1, iv47_Player1, iv48_Player1, iv49_Player1, iv50_Player1, iv51_Player1, iv52_Player1)
        var listPlayer_2 = arrayOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2, iv27_Player2, iv28_Player2, iv29_Player2, iv30_Player2, iv31_Player2, iv32_Player2, iv33_Player2, iv34_Player2, iv35_Player2, iv36_Player2, iv37_Player2, iv38_Player2, iv39_Player2, iv40_Player2, iv41_Player2, iv42_Player2, iv43_Player2, iv44_Player2, iv45_Player2, iv46_Player2, iv47_Player2, iv48_Player2, iv49_Player2, iv50_Player2, iv51_Player2, iv52_Player2)

        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)


        //turn to list of carte for player 1
        for (po in 0..3) {

            listPlayer_1_OutPut[po].setOnClickListener {
                if (testDestribute && checked1[po] == 1) {
                    counter++
                    test = true
//                    println("testDestribute = $testDestribute")
                    txt_Player1_Counter.text = "$counter"
                    checked1[po] = 0
                    checked1[4]--
                    setted1[indice1[po]] = 0
                    emptyPlaceFromTheListOfImage1[po] = 1
//                    printCheked(checked1)
                    // listPlayer_1_OutPut[po].visibility = View.GONE
                    listPlayer_1[indice1[po]].visibility = View.VISIBLE
                    listPlayer_1[indice1[po]].setImageResource(listPlayer_1_Image[indice1[po]])
                    listPlayer_1_OutPut[po].setImageResource(0)
                    /* if (isCompleted(checked1) && test) {

                         resetImageChosenByPlayer1()
                     }*/
                }
            }
        }

        //turn to list of layer 2
        for (po in 0..3) {

            listPlayer_2_OutPut[po].setOnClickListener {
                if (testDestribute && checked2[po] == 1) {
                    counter2++
                    test2 = true
                    txt_Player2_Counter.text = "$counter2"
                    checked2[po] = 0
                    checked2[4]--
                    setted2[indice2[po]] = 0
                    emptyPlaceFromTheListOfImage2[po] = 0
                    //printCheked(checked2)
                    listPlayer_2[indice2[po]].visibility = View.VISIBLE
                    listPlayer_2[indice2[po]].setImageResource(listPlayer_2_Image[indice2[po]])
                    listPlayer_2_OutPut[po].setImageResource(0)
                    if (isCompleted(checked2) && test) {
                        resetImageChosenByPlayer2()
                    }
                }
            }
        }
    }

    fun resetImageChosenByPlayer1() {
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)
        for (po in 0..3) {
            listPlayer_1_OutPut[po].setImageResource(R.drawable.marque)
        }
    }

    fun resetImageChosenByPlayer2() {
        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        for (po in 0..3) {
            listPlayer_2_OutPut[po].setImageResource(R.drawable.marque)
        }
    }

    fun resetListOfImage() {
        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1, iv27_Player1, iv28_Player1, iv29_Player1, iv30_Player1, iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1, iv37_Player1, iv38_Player1, iv39_Player1, iv40_Player1, iv41_Player1, iv42_Player1, iv43_Player1, iv44_Player1, iv45_Player1, iv46_Player1, iv47_Player1, iv48_Player1, iv49_Player1, iv50_Player1, iv51_Player1, iv52_Player1)
        var listPlayer_2 = arrayListOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2, iv27_Player2, iv28_Player2, iv29_Player2, iv30_Player2, iv31_Player2, iv32_Player2, iv33_Player2, iv34_Player2, iv35_Player2, iv36_Player2, iv37_Player2, iv38_Player2, iv39_Player2, iv40_Player2, iv41_Player2, iv42_Player2, iv43_Player2, iv44_Player2, iv45_Player2, iv46_Player2, iv47_Player2, iv48_Player2, iv49_Player2, iv50_Player2, iv51_Player2, iv52_Player2)
        for (po in 0..listPlayer_1.size - 1) {
            listPlayer_1[po].setImageResource(R.drawable.joker3)
            listPlayer_2[po].setImageResource(R.drawable.joker3)
        }
    }

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

    //Quatre cartes identiques
    fun verifyQuads(number1: IntArray, indice1: IntArray): Boolean {
        var test = false
        if (number1[indice1[0]] == number1[indice1[1]] && number1[indice1[1]] == number1[indice1[2]] && number1[indice1[2]] == number1[indice1[3]]) {
            test = true
        }
        return test
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

    fun printCheked(checked1: IntArray) {
        for (i in 0..4) {
            println("cheked[$i] = ${checked1[i]}")
        }
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

    fun setCarteSelectionOfGame() {
        val listSelection = arrayListOf(iv1_Selection, iv2_Selection, iv3_Selection, iv4_Selection, iv5_Selection, iv6_Selection, iv7_Selection, iv8_Selection, iv9_Selection, iv10_Selection, iv11_Selection, iv12_Selection, iv13_Selection)
        for (i in 0..12) {
            listSelection[i].setOnClickListener {
                if (testDestribute) {
                    iv_Joker.setImageResource(ListOfCarteSelected[i])
                    numberOfSelectedCarte = buNumberEvent(ListOfCarteSelected[i])

                }
            }
        }
    }


    fun setCarteToCenter() {

        counterLastSetCarte = 0
        Press_Player1.setOnClickListener {
            counterLastSetCarte = 0
            if (set1 && checked1[4] != 0) {
                set1 = false
                set2 = true
                isPressedSet = true
                for (i in 0..3) {
                    if (checked1[i] == 1) {
                        counterLastSetCarte++
                        listOfCarteInGame.add(listPlayer_1_Image[indice1[i]])

                        txtCounter.text = "X ${checked1[4]}"
                    }
                }
                resetImageChosenByPlayer1()
                resetArrayOfInt(checked1)
                printSetCarteIntoGame()
                println("counterLastSetCarte = $counterLastSetCarte)")
            }

        }

        Press_Player2.setOnClickListener {
            counterLastSetCarte = 0
            if (set2 && checked2[4] != 0) {
                set2 = false
                set1 = true
                isPressedSet = true
                for (i in 0..3) {
                    if (checked2[i] == 1) {
                        counterLastSetCarte++
                        listOfCarteInGame.add(listPlayer_2_Image[indice2[i]])

                        txtCounter.text = "X ${checked2[4]}"
                    }
                }
                resetImageChosenByPlayer2()
                resetArrayOfInt(checked2)
                printSetCarteIntoGame()
                println("counterLastSetCarte = $counterLastSetCarte)")
            }

        }
    }

    fun printSetCarteIntoGame() {
        for (i in 0..listOfCarteInGame.size - 1) {
            println(" listOfCarteInGame[$i] = ${listOfCarteInGame[i]}")
        }
    }


    //TODO : Force one Click

    fun addCarteToLoser() {
        var length = listOfCarteInGame.size - 1
        //listPlayer_1_Image[41] = listOfCarteInGame[length]
        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1, iv27_Player1, iv28_Player1, iv29_Player1, iv30_Player1, iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1, iv37_Player1, iv38_Player1, iv39_Player1, iv40_Player1, iv41_Player1, iv42_Player1, iv43_Player1, iv44_Player1, iv45_Player1, iv46_Player1, iv47_Player1, iv48_Player1, iv49_Player1, iv50_Player1, iv51_Player1, iv52_Player1)
        var listPlayer_2 = arrayListOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2, iv27_Player2, iv28_Player2, iv29_Player2, iv30_Player2, iv31_Player2, iv32_Player2, iv33_Player2, iv34_Player2, iv35_Player2, iv36_Player2, iv37_Player2, iv38_Player2, iv39_Player2, iv40_Player2, iv41_Player2, iv42_Player2, iv43_Player2, iv44_Player2, iv45_Player2, iv46_Player2, iv47_Player2, iv48_Player2, iv49_Player2, iv50_Player2, iv51_Player2, iv52_Player2)


        var position: Int
        println("lognuer = $length")
        while (length >= 0) {
            //player 1 play and lie or player 1 have a wrong prediction ==> return to all card to his own list hhhhh
            if ((!set1 && !istrueListOfCarte) || (set1 && istrueListOfCarte)) {
                println("#######################     Player 1   #######################")
                printArrayWithMsg(listPlayer_1_Image, "listPlayer_1_Image")
                counter++
                position = emptyImageFromListCheked(emptyPlaceFromTheListOfImage1)
                println("position emptyPlaceFromTheListOfImage1  = $position")
                listPlayer_1[position].visibility = View.VISIBLE
                listPlayer_1[position].setImageResource(listOfCarteInGame[length])
                println("listOfCarteInGame[length] = ${listOfCarteInGame[length]}")
                listPlayer_1_Image[position] = listOfCarteInGame[length]
                println(" listPlayer_1_Image[length] = listOfCarteInGame[length] = ${listPlayer_1_Image[position]}")
                number1[position] = buNumberEvent(listOfCarteInGame[length])
                println("number[$position] =  ${number1[position]}")
                listOfCarteInGame.removeAt(length)
                emptyPlaceFromTheListOfImage1[position] = 1
                println("\n")
                printArrayWithMsg(emptyPlaceFromTheListOfImage1, "emptyPlaceFromTheListOfImage1")
                setted1[position] = 0

                //player 2 play and lie or player 2 have a wrong prediction

            } else if ((!set2 && !istrueListOfCarte) || (set2 && istrueListOfCarte)) {
                println("#######################     Player 2   #######################")
                printArrayWithMsg(listPlayer_2_Image, "listPlayer_2_Image")
                counter2++
                position = emptyImageFromListCheked(emptyPlaceFromTheListOfImage2)
                println("position emptyPlaceFromTheListOfImage2  = $position")
                listPlayer_2[position].visibility = View.VISIBLE
                listPlayer_2[position].setImageResource(listOfCarteInGame[length])
                listPlayer_2_Image[position] = listOfCarteInGame[length]
                number2[position] = buNumberEvent(listOfCarteInGame[length])
                listOfCarteInGame.removeAt(length)
                emptyPlaceFromTheListOfImage2[position] = 1
                println("\n")
                printArrayWithMsg(emptyPlaceFromTheListOfImage2, "emptyPlaceFromTheListOfImage2")
                setted2[position] = 0
            }
            println("-----------------------------\n ------------------------lognuer = ------------- $length")
            length--
        }

        txt_Player2_Counter.text = "${counter2}"
        txt_Player1_Counter.text = "${counter}"
    }

    fun isLiar() {

        iv_Joker.setOnClickListener {
            if (isPressedSet) {
                if (isLastListOfCarteIsSame()) {
                    Toast.makeText(this, "good this is a true card ", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "HHHH you are a liar :p ", Toast.LENGTH_SHORT).show()
                }
                addCarteToLoser()
                isPressedSet = false
                findTheWinner()
            }
        }

    }

    fun findTheWinner() {
        print("Counter $counter")
        print("Counter2 =  $counter2")
        if (counter == 0) {
            val toast = Toast.makeText(this, "player 2 is the winner ", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 10, 110)
            toast.show()
        } else if (counter2 == 0) {
            val toast = Toast.makeText(this, "player 2 is the winner ", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 10, 110)
            toast.show()
        }
        if (counter == 0 || counter2 == 0) {
            Handler().postDelayed({

                //            /*var intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()*/

                resetGame()
            }, 1400)
        }
    }


    fun isLastListOfCarteIsSame(): Boolean {
        //must add true to istrueListOfCarte because it is  the default value !
        istrueListOfCarte = true
        var lastlistcarte = listOfCarteInGame.size - counterLastSetCarte
        println("counterLastSetCarte = " + counterLastSetCarte)
        println("listOfCarteInGame.size = " + listOfCarteInGame.size)
        println("lastlistcarte = " + lastlistcarte)
        println("numberOfSelectedCarte = " + numberOfSelectedCarte)

        while (lastlistcarte < listOfCarteInGame.size) {
            println("buNumberEvent(listOfCarteInGame[$lastlistcarte]) = " + buNumberEvent(listOfCarteInGame[lastlistcarte]))
            if (buNumberEvent(listOfCarteInGame[lastlistcarte]) != numberOfSelectedCarte) {
                istrueListOfCarte = false
                break
            }
            lastlistcarte++
        }
        return istrueListOfCarte

    }


    fun resetlistOfCarteInGame() {
        var length = listOfCarteInGame.size - 1
        while (length > 0) {
            println(listOfCarteInGame[length])
            listOfCarteInGame.removeAt(length)
            length--
            if (length > 0) {
                println(listOfCarteInGame[length])
            }
        }
        //printSetCarteIntoGame()

    }

    fun goReturn() {
        iv1_Player1.setOnClickListener {
            iv1_Player1_OutPut.setImageResource(listPlayer_1_Image[0])
            iv1_Player1.setImageResource(0)
        }
        iv1_Player1_OutPut.setOnClickListener {
            iv1_Player1.setImageResource(listPlayer_1_Image[0])
            iv1_Player1_OutPut.setImageResource(0)
        }

    }

    fun printverify() {
        for (i in 0..3) {
            println("indice1[$i] = " + indice2[i])
            println("numbr [$i]  =  " + number2[indice2[i]])
        }
    }

    //Just a test
    fun putIntoList() {
        var listPlayer_1 = arrayListOf(iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1, iv37_Player1, iv38_Player1, iv39_Player1)
        Press_Player1.setOnClickListener {
            for (i in 0..listPlayer_1.size - 1) {
                listPlayer_1[i].setImageResource(R.drawable.joker)
                listPlayer_1[i].visibility = View.VISIBLE
            }
        }
    }

    fun printArrayWithMsg(listPlayer_1_Image: IntArray, arrayName: String) {
        for (i in 0..listPlayer_1_Image.size - 1) {
            println("$arrayName[$i] = ${listPlayer_1_Image[i]}")
        }
    }

    fun resetGame() {
//        ListOfCarte = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13, R.drawable.trefle_01, R.drawable.trefle_02, R.drawable.trefle__03, R.drawable.trefle_04, R.drawable.trefle_05, R.drawable.trefle_06, R.drawable.trefle_07, R.drawable.trefle_08, R.drawable.trefle_09, R.drawable.trefle_10, R.drawable.trefle_11, R.drawable.trefle_12, R.drawable.trefle_13, R.drawable.coeur_01, R.drawable.coeur_02, R.drawable.coeur_03, R.drawable.coeur_04, R.drawable.coeur_05, R.drawable.coeur_06, R.drawable.coeur_07, R.drawable.coeur_08, R.drawable.coeur_09, R.drawable.coeur_10, R.drawable.coeur_11, R.drawable.coeur_12, R.drawable.coeur_13, R.drawable.pick_01, R.drawable.pique_02, R.drawable.pique_03, R.drawable.pique_04, R.drawable.pique_05, R.drawable.pique_06, R.drawable.pique_07, R.drawable.pique_08, R.drawable.pique_09, R.drawable.pique_10, R.drawable.pique_11, R.drawable.pique_12, R.drawable.pique_13)
//
////        resetlistOfCarteInGame()
//
//        resetArrayOfInt(checked1)
//        resetArrayOfInt(checked2)
//
//        resetArrayOfInt(emptyPlaceFromTheListOfImage1)
//        resetArrayOfInt(emptyPlaceFromTheListOfImage2)
//
//        resetArrayOfInt(listPlayer_1_Image)
//        resetArrayOfInt(listPlayer_2_Image)
//
//        resetArrayOfInt(setted1)
//        resetArrayOfInt(setted2)
//
//        resetListOfImage()
//        resetImageChosenByPlayer2()
//        resetImageChosenByPlayer1()
//
//        numberOfSelectedCarte = -1
//        testDestribute = false
//        isPressedSet = false
//        counterLastSetCarte = 0
//        set1 = true
//        set2 = true
//
//        counter = 26
//        counter2 = 26
//        txt_Player2_Counter.text = "${counter2}"
//        txt_Player1_Counter.text = "${counter}"

        val altdial = AlertDialog.Builder(this)

        altdial.setMessage("Do you want to Quit this app ???").setCancelable(false)
                .setPositiveButton("Yes") { dialog, which -> finish() }
                .setNegativeButton("No") { dialog, which ->
                    Toast.makeText(this, "Rest Game", Toast.LENGTH_LONG).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
//                .setNeutralButton("Cancel") { dialog, which -> dialog.cancel() }
        val alert = altdial.create()

        //alert.setTitle("Dialog Header")
        alert.show()


    }


}
