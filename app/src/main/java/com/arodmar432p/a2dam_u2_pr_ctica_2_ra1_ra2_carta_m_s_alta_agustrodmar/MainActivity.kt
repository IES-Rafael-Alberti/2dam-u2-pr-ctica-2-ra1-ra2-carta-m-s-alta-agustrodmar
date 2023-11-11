@file:Suppress("SpellCheckingInspection")

package com.arodmar432p.a2dam_u2_pr_ctica_2_ra1_ra2_carta_m_s_alta_agustrodmar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arodmar432p.a2dam_u2_pr_ctica_2_ra1_ra2_carta_m_s_alta_agustrodmar.ui.theme._2damu2prctica2ra1ra2cartamsaltaagustrodmarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2damu2prctica2ra1ra2cartamsaltaagustrodmarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JuegoBlackJack()
                }
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Preview
@Composable
fun JuegoBlackJack() {
    val context = LocalContext.current
    var cartaActual by remember { mutableStateOf(Carta(Naipe.AS, Palo.CORAZONES, 1, 11, 0)) }
    var mostrarCarta by remember { mutableStateOf(false) }

    Baraja.crearBaraja(context)
    Baraja.barajar()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (mostrarCarta) {
            val idDrawable = context.resources.getIdentifier(
                "${cartaActual.palo.toString().lowercase()}_${cartaActual.nombre.toString().lowercase()}",
                "drawable",
                context.packageName
            )
            Image(painter = painterResource(id = idDrawable), contentDescription = null)
        } else {
            val idDrawable = context.resources.getIdentifier("carta_boca_abajo", "drawable", context.packageName)
            Image(painter = painterResource(id = idDrawable), contentDescription = null)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {
                cartaActual = Baraja.dameCarta()
                mostrarCarta = true
            }) {
                Text("Dame Carta")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                Baraja.crearBaraja(context)
                Baraja.barajar()
                mostrarCarta = false
            }) {
                Text("Reiniciar")
            }
        }
    }
}