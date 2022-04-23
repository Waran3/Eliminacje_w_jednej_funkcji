package com.example.testsliderowwjednejfunkcji




import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.example.testsliderowwjednejfunkcji.ui.theme.TestSliderowWJednejFunkcjiTheme
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.apache.commons.net.ftp.FTPClient
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import kotlin.math.roundToInt



private val zawodnik_1 = mutableStateOf(0)
private val zawodnik_2 = mutableStateOf(0)
private val zawodnik_3 = mutableStateOf(0)
private val zawodnik_4 = mutableStateOf(0)
private val nazwa_sedzia = mutableStateOf("")


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSliderowWJednejFunkcjiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        //modifier = Modifier.fillMaxHeight(22f)
                        // modifier = Modifier.fillMaxSize(1f)
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Slidery_wszystkie()
                        //powitanie()
                        //Podaj_Nazwe_Sedziego()
                        //Slidery_gorne()
                        //Slidery_dolne()
                        //Zawodnicy_Punkty()
                        //Przycisk_zapisz()
                    }

                }
            }
        }
    }
}



@Composable
fun Slidery_wszystkie(){

   //////////////// nazwisko sedziego - poczatek ///////////////
    var txt by remember { mutableStateOf("") }
    nazwa_sedzia.value = txt
    TextField(
        value = txt, onValueChange = { txt = it },
        modifier = Modifier.padding(24.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )

    //////////////// nazwisko sedziego - koniec ///////////////

    //////////////////////// Poczatek gornych ////////////////////////////////

    var sliderPosition_1 by remember { mutableStateOf(0F) }
    var sliderPosition_2 by remember { mutableStateOf(0F) }
    var sliderPosition_3 by remember { mutableStateOf(0F) }

    var sliderPosition_4 by remember { mutableStateOf(0F) }
    var sliderPosition_5 by remember { mutableStateOf(0F) }
    var sliderPosition_6 by remember { mutableStateOf(0F) }

    var wynik_1 = (sliderPosition_1 * 33).roundToInt()
    var wynik_2 = (sliderPosition_2 * 33).roundToInt()
    var wynik_3 = (sliderPosition_3 * 33).roundToInt()
    var suma_2 = wynik_1 + wynik_2 + wynik_3

    var wynik_4 = (sliderPosition_4 * 33).roundToInt()
    var wynik_5 = (sliderPosition_5 * 33).roundToInt()
    var wynik_6 = (sliderPosition_6 * 33).roundToInt()
    var suma_3 = wynik_4 + wynik_5 + wynik_6

    val numer_zawodnika_1 = remember { mutableStateOf(1)    }
    val numer_zawodnika_2 = remember { mutableStateOf(2)    }
    val numer_zawodnika_3 = remember { mutableStateOf(3)    }
    val numer_zawodnika_4 = remember { mutableStateOf(4)    }


    zawodnik_2.value = suma_2
    zawodnik_3.value = suma_3

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(6.dp),
//verticalAlignment = Alignment.CenterVertically,
//horizontalArrangement = Arrangement.Center


    ) {
        Box(                // pole lewe górne
            Modifier
                .background(Color.Red)
                //.fillMaxSize(0.3F)
                .padding(0.dp)
                .background(Color.White)
                .fillMaxWidth(0.49F)
                .fillMaxHeight(0.3F)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_1 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_1,
                    onValueChange = { sliderPosition_1 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " BODY: ${(sliderPosition_2 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_2,
                    onValueChange = { sliderPosition_2 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " SOUL: ${(sliderPosition_3 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_3,
                    onValueChange = { sliderPosition_3 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK ${numer_zawodnika_2.value}   Wynik = $suma_2",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )


            }
        }

        Box(
            Modifier                        // pole prawe górne
                .background(Color.Yellow)
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(1F)
                .fillMaxHeight(0.3F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_4 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_4,
                    onValueChange = { sliderPosition_4 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_5 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_5,
                    onValueChange = { sliderPosition_5 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_6 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_6,
                    onValueChange = { sliderPosition_6 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Red,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK ${numer_zawodnika_3.value}   Wynik = $suma_3",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )
            }
        }
    }
    //return zawodnik_2
    //return zawodnik_3


//////////////////////// Koniec gornych ////////////////////////////////

//////////////////////// Poczatek dolnych  ////////////////////////////////

    var sliderPosition_1_1 by remember { mutableStateOf(0F) }
    var sliderPosition_2_2 by remember { mutableStateOf(0F) }
    var sliderPosition_3_3 by remember { mutableStateOf(0F) }

    var sliderPosition_4_4 by remember { mutableStateOf(0F) }
    var sliderPosition_5_5 by remember { mutableStateOf(0F) }
    var sliderPosition_6_6 by remember { mutableStateOf(0F) }

    var wynik_1_1 = (sliderPosition_1_1 * 33).roundToInt()
    var wynik_2_2 = (sliderPosition_2_2 * 33).roundToInt()
    var wynik_3_3 = (sliderPosition_3_3 * 33).roundToInt()
    var suma_1 = wynik_1_1 + wynik_2_2 + wynik_3_3

    var wynik_4_4 = (sliderPosition_4_4 * 33).roundToInt()
    var wynik_5_5 = (sliderPosition_5_5 * 33).roundToInt()
    var wynik_6_6 = (sliderPosition_6_6 * 33).roundToInt()
    var suma_4 = wynik_4_4 + wynik_5_5 + wynik_6_6

    zawodnik_1.value = suma_1
    zawodnik_4.value = suma_4

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(6.dp),
//verticalAlignment = Alignment.CenterVertically,
//horizontalArrangement = Arrangement.Center


    ) {
        Box(                // pole lewe dolne
            Modifier
                .background(Color.Red)
                //.fillMaxSize(0.3F)
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(0.49F)
                .fillMaxHeight(0.45F)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_1_1 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_1_1,
                    onValueChange = { sliderPosition_1_1 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " BODY: ${(sliderPosition_2_2 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_2_2,
                    onValueChange = { sliderPosition_2_2 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " SOUL: ${(sliderPosition_3_3 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_3_3,
                    onValueChange = { sliderPosition_3_3 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK ${numer_zawodnika_1.value}  Wynik = $suma_1",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,
                )

            }
        }

        Box(
            Modifier                        // pole prawe dolne
                .background(Color.Yellow)
                .padding(0.dp)
                .background(Color.White)
                .fillMaxWidth(1F)
                .fillMaxHeight(0.45F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_4_4 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_4_4,
                    onValueChange = { sliderPosition_4_4 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_5_5 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_5_5,
                    onValueChange = { sliderPosition_5_5 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_6_6 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_6_6,
                    onValueChange = { sliderPosition_6_6 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK ${numer_zawodnika_4.value}   Wynik = $suma_4",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )
            }
        }
    }


    /////////////////// Wyniki początek //////////////////////////
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "${nazwa_sedzia.value}",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(1),
            style = MaterialTheme.typography.h4,
        )
    }

    Text(
        text = " zawodnik ${numer_zawodnika_1.value} = ${zawodnik_1.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik ${numer_zawodnika_2.value} = ${zawodnik_2.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik ${numer_zawodnika_3.value} = ${zawodnik_3.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik ${numer_zawodnika_4.value} = ${zawodnik_4.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    ///////////////// wuniki koniec //////////////////



    //Przycisk ZAPISZ -początek /////////////////////////////////
    val counter  = remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Pojedynek numer: ${counter.value}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
        )
        Button(onClick = {
            counter.value++
            sliderPosition_1 = 0f
            sliderPosition_2 = 0f
            sliderPosition_3 = 0f
            sliderPosition_4 = 0f
            sliderPosition_5 = 0f
            sliderPosition_6 = 0f

            sliderPosition_1_1 = 0f
            sliderPosition_2_2 = 0f
            sliderPosition_3_3 = 0f
            sliderPosition_4_4 = 0f
            sliderPosition_5_5 = 0f
            sliderPosition_6_6 = 0f

            numer_zawodnika_1.value = numer_zawodnika_1.value +4
            numer_zawodnika_2.value = numer_zawodnika_2.value +4
            numer_zawodnika_3.value = numer_zawodnika_3.value +4
            numer_zawodnika_4.value = numer_zawodnika_4.value +4

            ////// zapis do pliku ////
            val client = FTPClient()
            val filename = "t:/kotlin/mk.txt"
            FileInputStream(filename).use {
                client.connect("ftp.net-line.com.pl")
                val login = client.login("vweb1201143", "ftpwiktoria")

                if (login) {
                    client.storeFile("abc.txt", it)
                    println("it = $it")

                    client.logout()
                    client.disconnect()
                }
            }


            ////// koniec zapisu do pliku /////



        }) {
            Text(text = "ZAPISZ")



        }
    }    //////    Przycisk ZAPISZ - koniec   /////////////////////////////////
}





@Composable
fun Slidery_gorne() {
    var sliderPosition_1 by remember { mutableStateOf(0F) }
    var sliderPosition_2 by remember { mutableStateOf(0F) }
    var sliderPosition_3 by remember { mutableStateOf(0F) }

    var sliderPosition_4 by remember { mutableStateOf(0F) }
    var sliderPosition_5 by remember { mutableStateOf(0F) }
    var sliderPosition_6 by remember { mutableStateOf(0F) }

    var wynik_1 = (sliderPosition_1 * 33).roundToInt()
    var wynik_2 = (sliderPosition_2 * 33).roundToInt()
    var wynik_3 = (sliderPosition_3 * 33).roundToInt()
    var suma_2 = wynik_1 + wynik_2 + wynik_3

    var wynik_4 = (sliderPosition_4 * 33).roundToInt()
    var wynik_5 = (sliderPosition_5 * 33).roundToInt()
    var wynik_6 = (sliderPosition_6 * 33).roundToInt()
    var suma_3 = wynik_4 + wynik_5 + wynik_6

    zawodnik_2.value = suma_2
    zawodnik_3.value = suma_3

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(6.dp),
//verticalAlignment = Alignment.CenterVertically,
//horizontalArrangement = Arrangement.Center


    ) {
        Box(                // pole lewe górne
            Modifier
                .background(Color.Red)
                //.fillMaxSize(0.3F)
                .padding(0.dp)
                .background(Color.White)
                .fillMaxWidth(0.49F)
                .fillMaxHeight(0.3F)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_1 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_1,
                    onValueChange = { sliderPosition_1 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " BODY: ${(sliderPosition_2 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_2,
                    onValueChange = { sliderPosition_2 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " SOUL: ${(sliderPosition_3 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_3,
                    onValueChange = { sliderPosition_3 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK 2   Wynik = $suma_2",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )


            }
        }

        Box(
            Modifier                        // pole prawe górne
                .background(Color.Yellow)
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(1F)
                .fillMaxHeight(0.3F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_4 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_4,
                    onValueChange = { sliderPosition_4 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_5 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_5,
                    onValueChange = { sliderPosition_5 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_6 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_6,
                    onValueChange = { sliderPosition_6 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Red,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK 3   Wynik = $suma_3",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )
            }
        }
    }

}


@Composable
fun Slidery_dolne() {
    var sliderPosition_1 by remember { mutableStateOf(0F) }
    var sliderPosition_2 by remember { mutableStateOf(0F) }
    var sliderPosition_3 by remember { mutableStateOf(0F) }

    var sliderPosition_4 by remember { mutableStateOf(0F) }
    var sliderPosition_5 by remember { mutableStateOf(0F) }
    var sliderPosition_6 by remember { mutableStateOf(0F) }

    var wynik_1 = (sliderPosition_1 * 33).roundToInt()
    var wynik_2 = (sliderPosition_2 * 33).roundToInt()
    var wynik_3 = (sliderPosition_3 * 33).roundToInt()
    var suma_1 = wynik_1 + wynik_2 + wynik_3

    var wynik_4 = (sliderPosition_4 * 33).roundToInt()
    var wynik_5 = (sliderPosition_5 * 33).roundToInt()
    var wynik_6 = (sliderPosition_6 * 33).roundToInt()
    var suma_4 = wynik_4 + wynik_5 + wynik_6

    zawodnik_1.value = suma_1
    zawodnik_4.value = suma_4

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(6.dp),
//verticalAlignment = Alignment.CenterVertically,
//horizontalArrangement = Arrangement.Center


    ) {
        Box(                // pole lewe dolne
            Modifier
                .background(Color.Red)
                //.fillMaxSize(0.3F)
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(0.49F)
                .fillMaxHeight(0.45F)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_1 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_1,
                    onValueChange = { sliderPosition_1 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " BODY: ${(sliderPosition_2 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_2,
                    onValueChange = { sliderPosition_2 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " SOUL: ${(sliderPosition_3 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_3,
                    onValueChange = { sliderPosition_3 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK 1   Wynik = $suma_1",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,
                )

            }
        }

        Box(
            Modifier                        // pole prawe dolne
                .background(Color.Yellow)
                .padding(0.dp)
                .background(Color.White)
                .fillMaxWidth(1F)
                .fillMaxHeight(0.45F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = " MIND: ${(sliderPosition_4 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_4,
                    onValueChange = { sliderPosition_4 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_5 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_5,
                    onValueChange = { sliderPosition_5 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " MIND: ${(sliderPosition_6 * 33).roundToInt()}",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sliderPosition_6,
                    onValueChange = { sliderPosition_6 = it },
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color.Black,
                        inactiveTickColor = Color.Gray
                    )
                )
                Text(
                    text = " ZAWODNIK 4   Wynik = $suma_4",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(1),
                    style = MaterialTheme.typography.h5,


                    )
            }
        }
    }
}

@Composable
fun Przycisk_zapisz() {
    val counter  = remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Pojedynek numer: ${counter.value}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
        )
        Button(onClick = {
            counter.value++


        }) {
            Text(text = "ZAPISZ")



        }
    }
}

@Composable
fun Podaj_Nazwe_Sedziego() {
    var txt by remember { mutableStateOf("") }
    nazwa_sedzia.value = txt
    TextField(
        value = txt, onValueChange = { txt = it },
        modifier = Modifier.padding(24.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )

}

@Composable
fun Zawodnicy_Punkty() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "${nazwa_sedzia.value}",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(1),
            style = MaterialTheme.typography.h4,
        )
    }

    Text(
        text = " zawodnik 1 = ${zawodnik_1.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik 2 = ${zawodnik_2.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik 3 = ${zawodnik_3.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
    Text(
        text = " zawodnik 4 = ${zawodnik_4.value}",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle(1),
        style = MaterialTheme.typography.h5,
    )
}


@Composable
fun powitanie() {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        )

        {
            TextField(
                value = textFieldState,
                label = {
                    Text(text = "Nazwa sędziego")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                }

            }) {
                Text(text = "ZATWIERDZ")
            }


        }


    }
}



