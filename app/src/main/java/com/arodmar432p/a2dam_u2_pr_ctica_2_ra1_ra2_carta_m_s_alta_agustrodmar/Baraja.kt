@file:Suppress("SpellCheckingInspection")

package com.arodmar432p.a2dam_u2_pr_ctica_2_ra1_ra2_carta_m_s_alta_agustrodmar

import android.annotation.SuppressLint
import android.content.Context


object Baraja {
    private val listaCartas = ArrayList<Carta>()

    @SuppressLint("DiscouragedApi")
    fun crearBaraja(context: Context) {
        for (palo in Palo.values()) {
            for (naipe in Naipe.values()) {
                val puntosMin = if (naipe == Naipe.AS) 1 else naipe.valor
                val puntosMax = if (naipe == Naipe.AS) 11 else naipe.valor
                val nombreRecurso = when (naipe) {
                    Naipe.AS -> "${palo.toString().lowercase()}a"
                    Naipe.DOS -> "${palo.toString().lowercase()}2"
                    Naipe.TRES -> "${palo.toString().lowercase()}3"
                    Naipe.CUATRO -> "${palo.toString().lowercase()}4"
                    Naipe.CINCO -> "${palo.toString().lowercase()}5"
                    Naipe.SEIS -> "${palo.toString().lowercase()}6"
                    Naipe.SIETE -> "${palo.toString().lowercase()}7"
                    Naipe.OCHO -> "${palo.toString().lowercase()}8"
                    Naipe.NUEVE -> "${palo.toString().lowercase()}9"
                    Naipe.DIEZ -> "${palo.toString().lowercase()}10"
                    Naipe.VALET -> "${palo.toString().lowercase()}j"
                    Naipe.DAME -> "${palo.toString().lowercase()}q"
                    Naipe.ROI -> "${palo.toString().lowercase()}k"
                }
                val idDrawable = context.resources.getIdentifier(nombreRecurso, "drawable", context.packageName)
                listaCartas.add(Carta(naipe, palo, puntosMin, puntosMax, idDrawable))

            }
        }
    }
    fun barajar() {
        listaCartas.shuffle()
    }

    fun dameCarta(): Carta {
        return listaCartas.removeAt(listaCartas.size - 1)
    }
}