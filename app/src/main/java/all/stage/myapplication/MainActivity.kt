package all.stage.myapplication

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*





class MainActivity : AppCompatActivity() {


    var ListOfCarte1_test = arrayListOf(R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.trefle_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.carreau_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.coeur_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01, R.drawable.pick_01)
    var ListOfCarte = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13, R.drawable.trefle_01, R.drawable.trefle_02, R.drawable.trefle__03, R.drawable.trefle_04, R.drawable.trefle_05, R.drawable.trefle_06, R.drawable.trefle_07, R.drawable.trefle_08, R.drawable.trefle_09, R.drawable.trefle_10, R.drawable.trefle_11, R.drawable.trefle_12, R.drawable.trefle_13, R.drawable.coeur_01, R.drawable.coeur_02, R.drawable.coeur_03, R.drawable.coeur_04, R.drawable.coeur_05, R.drawable.coeur_06, R.drawable.coeur_07, R.drawable.coeur_08, R.drawable.coeur_09, R.drawable.coeur_10, R.drawable.coeur_11, R.drawable.coeur_12, R.drawable.coeur_13, R.drawable.pick_01, R.drawable.pique_02, R.drawable.pique_03, R.drawable.pique_04, R.drawable.pique_05, R.drawable.pique_06, R.drawable.pique_07, R.drawable.pique_08, R.drawable.pique_09, R.drawable.pique_10, R.drawable.pique_11, R.drawable.pique_12, R.drawable.pique_13)
    var ListOfCarteSelected = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13)

    var number1 = IntArray(26)
    var number2 = IntArray(26)

    var listPlayer_1_Image = IntArray(26)
    var listPlayer_2_Image = IntArray(26)

    // indice for save the pos of image setted from the list of 26 carte
    var indice1 = IntArray(4)
    var indice2 = IntArray(4)

    // test of small list ,  the index 5 : is to save how carte is cheked
    var checked1 = IntArray(5) { 0 }
    var checked2 = IntArray(5) { 0 }
    //comment
    // to impose the dupplicated set carte
    var setted1 = IntArray(26) { 0 }
    var setted2 = IntArray(26) { 0 }


    //counter of carte in your main
    var counter = 26
    var counter2 = 26

    var listOfCarteInGame = ArrayList<Int>()


    // select carte number for palying
    var numberOfSelectedCarte = -1

    var testDestribute = false
    var isPressedSet = false

    var counterLastSetCarte = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        distributeRandomizeCarte()
        setImageCheked()
        turnImageToListOfCarte()
        setCarteSelectionOfGame()
        setCarteToCenter()
        isLiar()
        putIntoList ()
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
                        ListOfCarte.removeAt(randomi)

                        randomi2 = rand.nextInt(ListOfCarte.size)
                        listPlayer_2[i].setImageResource(ListOfCarte[randomi2])
                        number2[i] = buNumberEvent(ListOfCarte[randomi2])
                        listPlayer_2_Image[i] = ListOfCarte[randomi2]
                        ListOfCarte.removeAt(randomi2)
                    }
                    i++
                }
                listPlayer_1[25].setImageResource(ListOfCarte.last())
                listPlayer_1_Image[25] = ListOfCarte.last()
                number1[25] = buNumberEvent(ListOfCarte.last())
                listPlayer_2[25].setImageResource(ListOfCarte.first())
                listPlayer_2_Image[25] = ListOfCarte.first()
                number2[25] = buNumberEvent(ListOfCarte.first())
            } else {
                Toast.makeText(this, "Heh attendez vous a la prochaine tour  ", Toast.LENGTH_LONG).show()
            }

        }
    }


    

    //TODO : verification une seul click sur l'image  ====== done
    //TODO : set the iamge gone when it cheked ======= done
    //TODO : reset the block if we have a quads

    fun setImageCheked() {

        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1)
        var listPlayer_2 = arrayOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2)

        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)
        println(testDestribute)
        // set the image for the player 1

        for (po in 0..listPlayer_1.size - 1) {

            listPlayer_1[po].setOnClickListener {
                if (testDestribute && setted1[po] == 0) {
                    // il faut avoir la variable position ici sinon il ya un bug !!
                    var position = emptyImageFromListCheked(checked1)
                    if (isAnyEmptyImage(checked1) && position < 4) {
                        counter--
                        setted1[po] = 1
                        txt_Player1_Counter.text = "${counter}"
                        // listPlayer_1_OutPut[position].visibility = View.VISIBLE
                        listPlayer_1_OutPut[position].setImageResource(listPlayer_1_Image[po])
                        listPlayer_1[po].visibility = View.GONE
                        indice1[position] = po
                        checked1[position] = 1
                        checked1[4]++
                        // println("1er position = $position)")
                        // printCheked(checked1)
                        listPlayer_1[po].setImageResource(0)
                    }
                    // il faut reinitilliser la position
                    position = emptyImageFromListCheked(checked1)

//                    println("novelle = $position)")
//                    println("isCompleted(checked1) = ${isCompleted(checked1)}")
//                    println ("verifyQuads(number1, indice1) = ${verifyQuads(number1, indice1)}")

                    if (isCompleted(checked1)) {
                        if (verifyQuads(number1, indice1)) {
                            resetChekedListImage_1(checked1)
                            val toast = Toast.makeText(this, "This is A quads ", Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.TOP, 10, 110)
                            toast.show()
                            Handler().postDelayed({
                                resetListChecked()
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
                    // il faut avoir la variable position ici sinon il ya un bug !!
                    var position = emptyImageFromListCheked(checked2)
                    if (isAnyEmptyImage(checked2) && position < 4) {

                        counter2--

                        txt_Player2_Counter.text = "${counter2}"
                        listPlayer_2_OutPut[position].setImageResource(listPlayer_2_Image[po])
                        listPlayer_2[po].visibility = View.GONE
                        indice2[position] = po
                        checked2[position] = 1
                        checked2[4]++
                        setted2[po] = 1
                        println("1er position = $position)")
                        printCheked(checked2)
                        listPlayer_2[po].setImageResource(0)
                    }
                    // il faut reinitilliser la position
                    position = emptyImageFromListCheked(checked2)
                    println("novelle = $position)")

                    printverify()
                    if (isCompleted(checked2)) {

                        printverify()
                        if (verifyQuads(number2, indice2)) {
                            resetChekedListImage_1(checked2)
                            val toast = Toast.makeText(this, "This is A quads ", Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.BOTTOM, 10, 10)
                            toast.show()
                            Handler().postDelayed({
                                resetListChecked_Player2()
                            }, 1400)
                        }
                    }
                }
            }
        }
    }

    //TODO : no clikc if we haven't image ! ====== done
    //TODO : FIX the Counter if he Click In an Empty Image  ====== done



    fun turnImageToListOfCarte() {
        var test = false
        var test2 = false
        var listPlayer_1 = arrayListOf(iv1_Player1, iv2_Player1, iv3_Player1, iv4_Player1, iv5_Player1, iv6_Player1, iv7_Player1, iv8_Player1, iv9_Player1, iv10_Player1, iv11_Player1, iv12_Player1, iv13_Player1, iv14_Player1, iv15_Player1, iv16_Player1, iv17_Player1, iv18_Player1, iv19_Player1, iv20_Player1, iv21_Player1, iv22_Player1, iv23_Player1, iv24_Player1, iv25_Player1, iv26_Player1)
        var listPlayer_2 = arrayOf(iv1_Player2, iv2_Player2, iv3_Player2, iv4_Player2, iv5_Player2, iv6_Player2, iv7_Player2, iv8_Player2, iv9_Player2, iv10_Player2, iv11_Player2, iv12_Player2, iv13_Player2, iv14_Player2, iv15_Player2, iv16_Player2, iv17_Player2, iv18_Player2, iv19_Player2, iv20_Player2, iv21_Player2, iv22_Player2, iv23_Player2, iv24_Player2, iv25_Player2, iv26_Player2)

        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)


        //turn to list of carte for player 1
        for (po in 0..3) {

            listPlayer_1_OutPut[po].setOnClickListener {
                if (testDestribute && checked1[po] == 1) {
                    counter++
                    test = true
                    println("testDestribute = $testDestribute")
                    txt_Player1_Counter.text = "$counter"
                    checked1[po] = 0
                    checked1[4]--
                    setted1[indice1[po]] = 0
                    printCheked(checked1)
                    // listPlayer_1_OutPut[po].visibility = View.GONE
                    listPlayer_1[indice1[po]].visibility = View.VISIBLE
                    listPlayer_1[indice1[po]].setImageResource(listPlayer_1_Image[indice1[po]])
                    listPlayer_1_OutPut[po].setImageResource(0)
                    /* if (isCompleted(checked1) && test) {

                         resetListChecked()
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
                    //printCheked(checked2)
                    listPlayer_2[indice2[po]].visibility = View.VISIBLE
                    listPlayer_2[indice2[po]].setImageResource(listPlayer_2_Image[indice2[po]])
                    listPlayer_2_OutPut[po].setImageResource(0)
                    if (isCompleted(checked2) && test) {
                        resetListChecked_Player2()
                    }
                }
            }
        }
    }

    fun resetListChecked() {
        var listPlayer_1_OutPut = arrayListOf(iv1_Player1_OutPut, iv2_Player1_OutPut, iv3_Player1_OutPut, iv4_Player1_OutPut)
        for (po in 0..3) {
            listPlayer_1_OutPut[po].setImageResource(R.drawable.marque)
        }
    }

    fun resetListChecked_Player2() {
        var listPlayer_2_OutPut = arrayListOf(iv1_Player2_OutPut, iv2_Player2_OutPut, iv3_Player2_OutPut, iv4_Player2_OutPut)
        for (po in 0..3) {
            listPlayer_2_OutPut[po].setImageResource(R.drawable.marque)
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

    fun emptyImageFromListCheked(checked1: IntArray): Int {
        var output = -1
        for (i in 0..checked1.size - 1) {
            if (checked1[i] == 0) {
                output = i
                break
            }
        }
        /* var iss = 0
         while (iss<10) {
             if (checked1[0] == 0) {
                 output = 0
                 break
             } else if (checked1[1] == 1) {
                 output = 1
                 break
             } else if (checked1[2] == 2) {
                 output = 2
                 break
             } else if (checked1[3] == 3) {
                 output = 3
                 break
             }else break
             iss++
         }*/
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

    fun resetChekedListImage_1(checked1: IntArray) {
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
        var set1 = true
        var set2 = true
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
                resetListChecked()
                resetChekedListImage_1(checked1)
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
                resetListChecked_Player2()
                resetChekedListImage_1(checked2)
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

    fun isLiar() {
        //TODO : turn the carte to the loser
        //TODO : augmentation , decresing counter of carte
        //TODO : duplicate the listOfCarte in game : we most have a size of the list immidatly ,
        // TODO : we must have the size of the number of carte setted into game

        iv_Joker.setOnClickListener {
            if (isPressedSet) {
                if (isLastListOfCarteIsSame()) {
                    Toast.makeText(this, "good this is a true carte ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "HHHH you are a lier :p ", Toast.LENGTH_LONG).show()
                }
                resetlistOfCarteInGame()
            }
        }
    }

    fun isLastListOfCarteIsSame(): Boolean {
        var istrue = true
        var lastlistcarte = listOfCarteInGame.size - counterLastSetCarte
        println("counterLastSetCarte = " + counterLastSetCarte)
        println("listOfCarteInGame.size = " + listOfCarteInGame.size)
        println("lastlistcarte = " + lastlistcarte)
        println("numberOfSelectedCarte = " + numberOfSelectedCarte)

        while (lastlistcarte < listOfCarteInGame.size) {
            println("buNumberEvent(listOfCarteInGame[$lastlistcarte]) = " + buNumberEvent(listOfCarteInGame[lastlistcarte]))
            if (buNumberEvent(listOfCarteInGame[lastlistcarte]) != numberOfSelectedCarte) {
                istrue = false
                break
            }
            lastlistcarte++
        }
        return istrue

    }


    //TODO : simple ecrase instead of reset !
    fun resetlistOfCarteInGame() {
        var length = listOfCarteInGame.size - 1
        while (length > 0) {
            println(listOfCarteInGame[length])
            listOfCarteInGame.removeAt(length)
            length--
            if (length>0) {
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


    fun putIntoList (){
        var listPlayer_1 = arrayListOf(iv31_Player1, iv32_Player1, iv33_Player1, iv34_Player1, iv35_Player1, iv36_Player1,iv37_Player1,iv38_Player1,iv39_Player1)
        Press_Player1.setOnClickListener {
            for (i in 0 .. listPlayer_1.size-1){
                listPlayer_1[i].setImageResource(R.drawable.joker)
                listPlayer_1[i].visibility = View.VISIBLE
            }
        }
    }

    //TODO : add the image id and put it GONE until one lose the round*
    //TODO : put the carte into the loser & start the play randomly

}


/*  if (posOutput1 < 4) {
                  counter--
                  txt_Player1_Counter.text = "${counter}"
                  listPlayer_1_OutPut[posOutput1].setImageResource(listPlayer_1_Image[po])
                  indice1[posOutput1] = po
                  checked1[posOutput1]=1
                  listPlayer_1[po].setImageResource(0)
              }
              posOutput1++
              if (posOutput1 == 4 ) {
                  posOutput1 = 0
                  // break
              }
              if (counter == 22 ) {
                  // Toast.makeText(this,"This is A quads ",Toast.LENGTH_LONG).show()
                  verifyQuads()
              }*/

