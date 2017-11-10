package all.stage.myapplication


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.Gravity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.toast


class Main2Activity : AppCompatActivity() {

    private var ListOfCarte = arrayListOf(R.drawable.carreau_01, R.drawable.carreau_02, R.drawable.carreau_03, R.drawable.carreau_04, R.drawable.carreau_05, R.drawable.carreau_06, R.drawable.carreau_07, R.drawable.carreau_08, R.drawable.carreau_09, R.drawable.carreau_10, R.drawable.carreau_11, R.drawable.carreau_12, R.drawable.carreau_13, R.drawable.trefle_01, R.drawable.trefle_02, R.drawable.trefle__03, R.drawable.trefle_04, R.drawable.trefle_05, R.drawable.trefle_06, R.drawable.trefle_07, R.drawable.trefle_08, R.drawable.trefle_09, R.drawable.trefle_10, R.drawable.trefle_11, R.drawable.trefle_12, R.drawable.trefle_13, R.drawable.coeur_01, R.drawable.coeur_02, R.drawable.coeur_03, R.drawable.coeur_04, R.drawable.coeur_05, R.drawable.coeur_06, R.drawable.coeur_07, R.drawable.coeur_08, R.drawable.coeur_09, R.drawable.coeur_10, R.drawable.coeur_11, R.drawable.coeur_12, R.drawable.coeur_13, R.drawable.pick_01, R.drawable.pique_02, R.drawable.pique_03, R.drawable.pique_04, R.drawable.pique_05, R.drawable.pique_06, R.drawable.pique_07, R.drawable.pique_08, R.drawable.pique_09, R.drawable.pique_10, R.drawable.pique_11, R.drawable.pique_12, R.drawable.pique_13)

    private var ConstantnumberOfCard = 52
    private var number1 = IntArray(ConstantnumberOfCard)
    private var number2 = IntArray(ConstantnumberOfCard)

    private var listPlayer_1_Image = ArrayList<Int>()
    private var listPlayer_2_Image = IntArray(ConstantnumberOfCard)

    // indice for save the pos of image setted from the list of 52 carte
    private var indice1 = IntArray(4)
    private var indice2 = IntArray(4)

    // test of small list ,  the index 5 : is to save how carte is cheked
    private var checked1 = IntArray(5) { 0 }
    private var checked2 = IntArray(5) { 0 }
    //comment
    // to impose the dupplicated set carte
    private var setted1 = IntArray(ConstantnumberOfCard) { 0 }
    private var setted2 = IntArray(ConstantnumberOfCard) { 0 }

    private var emptyPlaceFromTheListOfImage1 = IntArray(ConstantnumberOfCard) { 0 }
    private var emptyPlaceFromTheListOfImage2 = IntArray(ConstantnumberOfCard) { 0 }


    //counter of carte in your main
    private var counter = 26
    private var counter2 = 26

    private var listOfCarteInGame = ArrayList<Int>()


    // select carte number for palying
    private var numberOfSelectedCarte = -1

    private var testDestribute = false
    private var isPressedSet = false

    private var counterLastSetCarte = 0

    //player curently play
    private var set1 = true
    private var set2 = true
    var istrueListOfCarte = true
    var TelLiar = false

    private var lastlistcarte = 0

    var tab = Array(15) { IntArray(15) }

    var indiceMaxOcc = 0

    var randomList = arrayListOf(0,0,1,1,0)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvRound.text="$nbrOfRound"
        counterRoundPlyer1.text="$nbcounterRoundPlyer1"
        counterRoundPlyer2.text="$nbcounterRoundPlyer2"

        //if (!set2 && set1 ){
            startTimer()
       // }
        distributeRandomizeCarte()
        setImageCheked()
        turnImageToListOfCarte()
        setCarteSelectioonOfGame()
        setCarteToCenter()
        isLiar()


    }


    fun distributeRandomizeCarte() {

        var listPlayers_2 = arrayListOf(iv1_Players2, iv2_Players2, iv3_Players2, iv4_Players2, iv5_Players2, iv6_Players2, iv7_Players2, iv8_Players2, iv9_Players2, iv10_Players2, iv11_Players2, iv12_Players2, iv13_Players2, iv14_Players2, iv15_Players2, iv16_Players2, iv17_Players2, iv18_Players2, iv19_Players2, iv20_Players2, iv21_Players2, iv22_Players2, iv23_Players2, iv24_Players2, iv25_Players2, iv26_Players2)

        if (!testDestribute) {


            //TODO : Find Solution for loading image without using Large Heap
        /*    testDestribute = true
            var j =0
            var nb = 22

            //Handler().postDelayed({
            while (j <5 ) {

                Handler().postDelayed({
                var rand = Random()

                if (ListOfCarte.size != 0) {
                       for (i in (nb/5)*j ..(nb/5)*(j+1)) {
                           var randomi = rand.nextInt(ListOfCarte.size)
                           number1[i] = buNumberEvent(ListOfCarte[randomi])
                           listPlayer_1_Image.add(ListOfCarte[randomi])
                           emptyPlaceFromTheListOfImage1[i] = 1
                           ListOfCarte.removeAt(randomi)


                           var randomi2 = rand.nextInt(ListOfCarte.size)
                           Picasso.with(this).load(ListOfCarte[randomi2]).into(listPlayers_2[i])
                           number2[i] = buNumberEvent(ListOfCarte[randomi2])
                           listPlayer_2_Image[i] = ListOfCarte[randomi2]
                           emptyPlaceFromTheListOfImage2[i] = 1
                           ListOfCarte.removeAt(randomi2)

                       }
                }
                     },400)

                j++
            }
*/
            testDestribute = true
            var i = 25
            var imax = 5
            //Handler().postDelayed({
            while (i >= 0) {

                var rand = Random()

                if (ListOfCarte.size != 0) {
               //     while (i<imax )
                    var  randomi = rand.nextInt(ListOfCarte.size)
                    number1[i] = buNumberEvent(ListOfCarte[randomi])
                    listPlayer_1_Image.add(ListOfCarte[randomi])
                    emptyPlaceFromTheListOfImage1[i] = 1
                    ListOfCarte.removeAt(randomi)


                    var randomi2 = rand.nextInt(ListOfCarte.size)
                    Picasso.with(this).load(ListOfCarte[randomi2]).into(listPlayers_2[i])
                    number2[i] = buNumberEvent(ListOfCarte[randomi2])
                    listPlayer_2_Image[i] = ListOfCarte[randomi2]
                    emptyPlaceFromTheListOfImage2[i] = 1
                    ListOfCarte.removeAt(randomi2)


                }

                i--
            }

        } else {

            Toast.makeText(this, "Heh Wait For The Next Round !   ", Toast.LENGTH_LONG).show()
        }
        printArrayWithMsg(number2, "number2")
        createMatrice()
        println("  var indiceMaxOcc = $indiceMaxOcc")

    }

    fun setImageCheked() {

        var listPlayers_2 = arrayListOf(iv1_Players2, iv2_Players2, iv3_Players2, iv4_Players2, iv5_Players2, iv6_Players2, iv7_Players2, iv8_Players2, iv9_Players2, iv10_Players2, iv11_Players2, iv12_Players2, iv13_Players2, iv14_Players2, iv15_Players2, iv16_Players2, iv17_Players2, iv18_Players2, iv19_Players2, iv20_Players2, iv21_Players2, iv22_Players2, iv23_Players2, iv24_Players2, iv25_Players2, iv26_Players2, iv27_Players2, iv28_Players2, iv29_Players2, iv30_Players2, iv31_Players2, iv32_Players2, iv33_Players2, iv34_Players2, iv35_Players2, iv36_Players2, iv37_Players2, iv38_Players2, iv39_Players2, iv40_Players2, iv41_Players2, iv42_Players2, iv43_Players2, iv44_Players2, iv45_Players2, iv46_Players2, iv47_Players2, iv48_Players2, iv49_Players2, iv50_Players2, iv51_Players2, iv52_Players2)

        var listPlayers_2_OutPut = arrayListOf(iv1_Players2_OutPut, iv2_Players2_OutPut, iv3_Players2_OutPut, iv4_Players2_OutPut)

        // set the image for the player 2

        for (po in 0..listPlayers_2.size - 1) {

            listPlayers_2[po].setOnClickListener {

                if (setted2[po] == 0) {

                    // position must be here !
                    var position = emptyImageFromListCheked(checked2)
                    if (isAnyEmptyImage(checked2) && position < 4) {

                        counter2--
                        counterCardPlayers2.text = "+${counter2}"
                        Picasso.with(this).load(listPlayer_2_Image[po]).into(listPlayers_2_OutPut[position])
                        listPlayers_2[po].visibility = View.GONE

                        indice2[position] = po
                        checked2[position] = 1
                        emptyPlaceFromTheListOfImage2[po] = 0
                        checked2[4]++
                        setted2[po] = 1
                        Picasso.with(this).load(R.drawable.marque).into(listPlayers_2[po])

                    }

                    if (isCompleted(checked2)) {

                        if (verifyQuads(number2, indice2)) {

                            resetArrayOfInt(checked2)
                            val toast = Toast.makeText(this, "This is A quads ", Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.BOTTOM, 10, 10)
                            toast.show()

                            Handler().postDelayed({
                                resetImageChosenByPlayer2()
                            }, 400)

                        }

                    }

                }

            }

        }
    }

    fun turnImageToListOfCarte() {

        var test = false

        var listPlayers_2 = arrayListOf(iv1_Players2, iv2_Players2, iv3_Players2, iv4_Players2, iv5_Players2, iv6_Players2, iv7_Players2, iv8_Players2, iv9_Players2, iv10_Players2, iv11_Players2, iv12_Players2, iv13_Players2, iv14_Players2, iv15_Players2, iv16_Players2, iv17_Players2, iv18_Players2, iv19_Players2, iv20_Players2, iv21_Players2, iv22_Players2, iv23_Players2, iv24_Players2, iv25_Players2, iv26_Players2)
        var listPlayers_2_OutPut = arrayListOf(iv1_Players2_OutPut, iv2_Players2_OutPut, iv3_Players2_OutPut, iv4_Players2_OutPut)


        var str: String? = null


        //turn to list of Payer 2
        for (po in 0..3) {

            listPlayers_2_OutPut[po].setOnClickListener {

                if (testDestribute && checked2[po] == 1) {

                    counter2++
                    counterCardPlayers2.text = "+$counter2"
                    checked2[po] = 0
                    checked2[4]--
                    setted2[indice2[po]] = 0
                    emptyPlaceFromTheListOfImage2[po] = 0
                    listPlayers_2[indice2[po]].visibility = View.VISIBLE
                    Picasso.with(this).load(listPlayer_2_Image[indice2[po]]).into(listPlayers_2[indice2[po]])
                    listPlayers_2_OutPut[po].setImageResource(0)

                    if (isCompleted(checked2) && test) {
                        resetImageChosenByPlayer2()
                    }

                }
            }
        }
    }


    fun resetImageChosenByPlayer2() {

        var listPlayers_2_OutPut = arrayListOf(iv1_Players2_OutPut, iv2_Players2_OutPut, iv3_Players2_OutPut, iv4_Players2_OutPut)

        for (po in 0..3) Picasso.with(this).load((R.drawable.marque)).into(listPlayers_2_OutPut[po])

    }


    fun resetImageChosenByPlayer1() {

        var listPlayers_1_OutPut = arrayListOf(iv1_Players1_OutPut, iv2_Players1_OutPut, iv3_Players1_OutPut, iv4_Players1_OutPut)

        for (po in 0..3) Picasso.with(this).load((R.drawable.marque)).into(listPlayers_1_OutPut[po])

    }


    fun setCarteSelectioonOfGame() {

        val listSelectioon = arrayListOf(iv1_Selectioon, iv2_Selectioon, iv3_Selectioon, iv4_Selectioon, iv5_Selectioon, iv6_Selectioon, iv7_Selectioon, iv8_Selectioon, iv9_Selectioon, iv10_Selectioon, iv11_Selectioon, iv12_Selectioon, iv13_Selectioon)

        for (i in 0..12) {

            listSelectioon[i].setOnClickListener {

                if (testDestribute) {

                    Picasso.with(this).load(ListOfCarteSelected[i]).into(CardChoosen)
                    numberOfSelectedCarte = buNumberEvent(ListOfCarteSelected[i])

                }
            }
        }
    }


    fun setCarteToCenter() {

        var listPlayers_1_OutPut = arrayListOf(iv1_Players1_OutPut, iv2_Players1_OutPut, iv3_Players1_OutPut, iv4_Players1_OutPut)
        println("  var indiceMaxOcc = $indiceMaxOcc")
        lnOflistPlayers_1_OutPut.visibility = View.GONE
        counterLastSetCarte = 0

        Press_Players2.setOnClickListener {
            println("  var indiceMaxOcc = $indiceMaxOcc")
            lnOflistPlayers_1_OutPut.visibility = View.GONE
            counterLastSetCarte = 0

            if (set2 && checked2[4] != 0) {

                set2 = false
                set1 = true
                isPressedSet = true

                for (i in 0..3) {

                    if (checked2[i] == 1) {

                        counterLastSetCarte++
                        listOfCarteInGame.add(listPlayer_2_Image[indice2[i]])
                        numberOfCardChoosen.text = "X${checked2[4]}"

                    }

                }

                resetImageChosenByPlayer2()
                resetArrayOfInt(checked2)
                printArrayListWithMsg(listOfCarteInGame, "listOfCarteInGame")
                Press_Players2.alpha = 0.3F
                println("counterLastSetCarte = $counterLastSetCarte)")
                resetImageChosenByPlayer1()
                printArrayListWithMsg(listOfCarteInGame, "listOfCarteInGame")

            }


            Handler().postDelayed({

//                var randomiPressed = intArrayOf(0,1,1,1)
//                var rand = Random()
//                var randomi = rand.nextInt(randomiPressed.size - 1)
//
//                if (isPressedSet && randomiPressed[randomi] == 1 ) {
//
//                    if (isLastListOfCarteIsSame()) {
//
//                        Toast.makeText(this, "good this is a true card ", Toast.LENGTH_SHORT).show()
//
//                    } else {
//
//                        Toast.makeText(this, "HHHH you are a liar :p ", Toast.LENGTH_SHORT).show()
//                        TelLiar = true
//                    }
//
//                    addCarteToLoser()
//                    isPressedSet = false
//                    findTheWinner()
//
//
//                }
//                (TelLiar ||(set1 && randomiPressed[randomi] != 1)
                if (set1 ) {

                    counterLastSetCarte = 0
//                    TelLiar=false
                    set1 = false
                    set2 = true
                    isPressedSet = true
                    var cc = 0
                    var rand = Random()

                    var rest = if (listPlayer_1_Image.size > 4) 3 else listPlayer_1_Image.size % 4
                    var randNumber = if (rest >= 3) rand.nextInt(rest) else rest

                    if (rest >= 3) {

                        for (i in 0..randNumber) {

                            indice1[i] = rand.nextInt(listPlayer_1_Image.size - 1)
                            counterLastSetCarte++
                            listOfCarteInGame.add(listPlayer_1_Image[indice1[i]])
                            Picasso.with(this).load(listPlayer_1_Image[indice1[i]]).into(listPlayers_1_OutPut[i])
                            listPlayer_1_Image.removeAt(indice1[i])
                            cc++
                            counter--

                        }

                    } else {

                        var length = listPlayer_1_Image.size - 1

                        while (length >= 0) {

                            listOfCarteInGame.add(listPlayer_1_Image[length])
                            Picasso.with(this).load(listPlayer_1_Image[length]).into(listPlayers_1_OutPut[length])
                            listPlayer_1_Image.removeAt(length)
                            length--
                            toast("that's good ")
                            cc++
                            counter--

                        }

                    }


                    counterCardPlayers1.text = "+${counter}"
                    numberOfCardChoosen.text = "X$cc"

//                    println("counterLastSetCarte = $counterLastSetCarte)")
//                    printArrayListWithMsg(listOfCarteInGame, "listOfCarteInGame")


                }

            }, 400)

        }


    }

    fun addCarteToLoser() {

        var length = listOfCarteInGame.size - 1
        var listPlayers_2 = arrayListOf(iv1_Players2, iv2_Players2, iv3_Players2, iv4_Players2, iv5_Players2, iv6_Players2, iv7_Players2, iv8_Players2, iv9_Players2, iv10_Players2, iv11_Players2, iv12_Players2, iv13_Players2, iv14_Players2, iv15_Players2, iv16_Players2, iv17_Players2, iv18_Players2, iv19_Players2, iv20_Players2, iv21_Players2, iv22_Players2, iv23_Players2, iv24_Players2, iv25_Players2, iv26_Players2, iv27_Players2, iv28_Players2, iv29_Players2, iv30_Players2, iv31_Players2, iv32_Players2, iv33_Players2, iv34_Players2, iv35_Players2, iv36_Players2, iv37_Players2, iv38_Players2, iv39_Players2, iv40_Players2, iv41_Players2, iv42_Players2, iv43_Players2, iv44_Players2, iv45_Players2, iv46_Players2, iv47_Players2, iv48_Players2, iv49_Players2, iv50_Players2, iv51_Players2, iv52_Players2)

        var position: Int

        while (length >= 0) {

            //player 1 play and lie or player 1 have a wrong prediction ==> return to all card to his own list hhhhh

            if ((!set1 && !istrueListOfCarte) || (set1 && istrueListOfCarte)) {


//                println("#######################     Player 1   #######################")
//                printArrayListWithMsg(listPlayer_1_Image, "listPlayer_1_Image")

                counter++
                listPlayer_1_Image.add(listOfCarteInGame[length])
                showCardOfLiar()
                number1[listPlayer_1_Image.size - 1] = buNumberEvent(listOfCarteInGame[length])
                listOfCarteInGame.removeAt(length)
                setted1[listPlayer_1_Image.size - 1] = 0


                //player 2 play and lie or player 2 have a wrong prediction

            } else if ((!set2 && !istrueListOfCarte) || (set2 && istrueListOfCarte)) {

//                println("#######################     Player 2   #######################")
//                printArrayWithMsg(listPlayer_2_Image, "listPlayer_2_Image")

                counter2++
                position = emptyImageFromListCheked(emptyPlaceFromTheListOfImage2)

//                println("position emptyPlaceFromTheListOfImage2  = $position")

                listPlayers_2[position].visibility = View.VISIBLE
                listPlayers_2[position].setImageResource(listOfCarteInGame[length])
                listPlayer_2_Image[position] = listOfCarteInGame[length]
                number2[position] = buNumberEvent(listOfCarteInGame[length])
                listOfCarteInGame.removeAt(length)
                emptyPlaceFromTheListOfImage2[position] = 1
//                println("\n")
//                printArrayWithMsg(emptyPlaceFromTheListOfImage2, "emptyPlaceFromTheListOfImage2")
                setted2[position] = 0

            }

            length--

        }

        counterCardPlayers2.text = "+${counter2}"
        counterCardPlayers1.text = "+${counter}"

        createMatrice()



    }


    fun showCardOfLiar() {

        var listPlayers_1_OutPut = arrayListOf(iv1_Players1_OutPut, iv2_Players1_OutPut, iv3_Players1_OutPut, iv4_Players1_OutPut)
        var i = 0

        lnOflistPlayers_1_OutPut.visibility = View.VISIBLE

        while (i<4 && lastlistcarte < listOfCarteInGame.size) {

            Picasso.with(this).load(listOfCarteInGame[lastlistcarte]).into(listPlayers_1_OutPut[i])
            i++
            lastlistcarte++


        }


    }


    fun isLastListOfCarteIsSame(): Boolean {

        istrueListOfCarte = true
        lastlistcarte = listOfCarteInGame.size - counterLastSetCarte

        while (lastlistcarte < listOfCarteInGame.size) {

            if (buNumberEvent(listOfCarteInGame[lastlistcarte]) != numberOfSelectedCarte) {

                istrueListOfCarte = false
                break

            }

            lastlistcarte++

        }

        return istrueListOfCarte


    }


    fun isLiar() {

        CardChoosen.setOnClickListener {

            if (isPressedSet) {

                var msg = ""
//                if (isLastListOfCarteIsSame()) {
                    //player 2 is wrong
                if ((!set1 && !istrueListOfCarte) || (set1 && istrueListOfCarte)){
                        msg = "You Are a Liar "
                    }else {
                        msg="Good This Is A True Card  "
                    }
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

//                } else {

//                    Toast.makeText(this, "HHHH you are a liar :p ", Toast.LENGTH_SHORT).show()
//                }

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

            val toast = Toast.makeText(this, "player 1 is the winner ", Toast.LENGTH_LONG)
            nbcounterRoundPlyer1++
            toast.setGravity(Gravity.TOP, 10, 110)
            toast.show()

        } else if (counter2 == 0) {

            val toast = Toast.makeText(this, "player 2 is the winner ", Toast.LENGTH_LONG)
            nbcounterRoundPlyer2++
            toast.setGravity(Gravity.TOP, 10, 110)
            toast.show()

        }


        if (counter == 0 || counter2 == 0) {

            Handler().postDelayed({

                resetGame()

            }, 1400)

        }


    }

    fun resetGame() {
        nbrOfRound++
        val altdial = AlertDialog.Builder(this)

        altdial.setMessage("Do you want to Quit this app ???").setCancelable(false)
                .setPositiveButton("Yes") { dialog, which -> finish() }
                .setNegativeButton("No") {

                    dialog, which ->
                    Toast.makeText(this, "Rest Game", Toast.LENGTH_LONG).show()
                    var intent = Intent(this, Main2Activity::class.java)
                    intent.putExtra("nbrOfRound",nbrOfRound)
                    startActivity(intent)
                    finish()

                }

        val alert = altdial.create()
        alert.show()


    }

    fun createMatrice(){

        for (i in 0 ..tab.size-1){
            for (j in 0 .. tab.size-1){
                tab[i][j]=0
            }
        }
        for (i in 0 until listPlayer_1_Image.size - 1) {

            tab[buNumberEvent(listPlayer_1_Image[i])][0]++
            tab[buNumberEvent(listPlayer_1_Image[i])][tab[buNumberEvent(listPlayer_1_Image[i])][0]] = i
        }


        for (j in 1..14) {
            if (tab[j][0] > indiceMaxOcc) indiceMaxOcc = j
        }
        tab[14][0]=indiceMaxOcc
        for ( i in 0 ..tab.size-1){
            for ( j in 0 ..5){
                print("tab[$i][$j] )=${tab[i][j]} \t")
            }
            println()
        }
    }

    private fun startTimer() {

        timer!!.base = SystemClock.elapsedRealtime()
        timer!!.start()
        timer!!.visibility = View.VISIBLE

    }
}


