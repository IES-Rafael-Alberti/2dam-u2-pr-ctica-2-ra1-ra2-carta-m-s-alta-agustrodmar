@file:Suppress("SpellCheckingInspection")

package com.arodmar432p.a2dam_u2_pr_ctica_2_ra1_ra2_carta_m_s_alta_agustrodmar

data class Carta(
    val nombre: Naipe,
    val palo: Palo,
    val puntosMin: Int,
    val puntosMax: Int,
    val idDrawable: Int
)