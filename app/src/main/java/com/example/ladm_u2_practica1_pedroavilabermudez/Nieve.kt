package com.example.ladm_u2_practica1_pedroavilabermudez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.lang.Thread.sleep
import kotlin.random.Random

class Nieve(l: Lienzo) {
    val l = l
    var velocidad = 10f
    var tamano = 10f
    var respaldoTamano = 0f
    var x: Float = Random.nextLong(0, 1080).toFloat()
    var y: Float = rand(1, 1823)
    var contadorTiempo = 250

    init {
        val r = rand(5, 30)
        velocidad = r
        tamano = r
        respaldoTamano = tamano
    }


    fun rand(desde: Long, limite: Long): Float {
        return Random.nextLong(desde, limite).toFloat()
    }


    fun mover() {
        contadorTiempo--
        if (y < l.height) {
            y += velocidad
        } else {
            y = 10f
            if (contadorTiempo <= 0) {
                if (rand(0, 20) < 8f) {
                    tamano = 0f
                }
                if (contadorTiempo <= -400) {
                    tamano = respaldoTamano
                    contadorTiempo=250
                }
            }


        }
    }

        fun pintar(canvas: Canvas) {
            val p = Paint()
            p.color = Color.WHITE
            canvas.drawCircle(x, y, tamano, p)
        }


    }