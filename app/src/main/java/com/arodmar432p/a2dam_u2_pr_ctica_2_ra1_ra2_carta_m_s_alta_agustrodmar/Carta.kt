@file:Suppress("SpellCheckingInspection")

package com.arodmar432p.a2dam_u2_pr_ctica_2_ra1_ra2_carta_m_s_alta_agustrodmar

/**
 * Representa una carta de baraja.
 *
 * @property nombre El nombre del naipe de la carta.
 * @property palo El palo de la carta.
 * @property puntosMin Los puntos mínimos que puede tener la carta.
 * @property puntosMax Los puntos máximos que puede tener la carta.
 * @property idDrawable El identificador del recurso drawable de la carta.
 */
data class Carta(
    val nombre: Naipe,
    val palo: Palo,
    val puntosMin: Int,
    val puntosMax: Int,
    val idDrawable: Int
)
