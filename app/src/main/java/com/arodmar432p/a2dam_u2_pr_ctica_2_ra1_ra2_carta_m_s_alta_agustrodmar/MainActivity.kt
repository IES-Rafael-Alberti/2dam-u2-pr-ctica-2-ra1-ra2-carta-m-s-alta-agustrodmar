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


**
 * Representa la actividad principal de la aplicación.
 */
class MainActivity : ComponentActivity() {

    /**
     * Función que se llama al crear la actividad.
     * @param savedInstanceState Bundle que contiene el estado de la actividad.
     */
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

/**
 * Función composable que representa el juego de BlackJack.
 */
@SuppressLint("DiscouragedApi")
@Preview
@Composable
fun JuegoBlackJack() {
    // Obtener el contexto actual
    val context = LocalContext.current

    // Estado para la carta actual
    var cartaActual by remember { mutableStateOf(Carta(Naipe.AS, Palo.CORAZONES, 1, 11, 0)) }

    // Estado para mostrar la carta
    var mostrarCarta by remember { mutableStateOf(false) }

    // Crear y barajar la baraja
    Baraja.crearBaraja(context)
    Baraja.barajar()

    // Diseño de la interfaz de usuario
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Determina el id del recurso drawable
        val idDrawable = if (mostrarCarta) {
            cartaActual.idDrawable
        } else {
            context.resources.getIdentifier("bocabajo", "drawable", context.packageName)
        }

        // Muestra la imagen de la carta
        Image(painter = painterResource(id = idDrawable), contentDescription = null)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Botón para obtener una carta
            Button(onClick = {
                cartaActual = Baraja.dameCarta()
                mostrarCarta = true
            }) {
                Text("Dame Carta")
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón para reiniciar el juego
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
