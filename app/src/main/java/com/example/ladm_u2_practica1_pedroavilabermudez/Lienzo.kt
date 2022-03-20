package com.example.ladm_u2_practica1_pedroavilabermudez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.ArrayList
import kotlin.random.Random

class Lienzo(main: MainActivity) : View(main) {
    val main = main
    var fondo = rgb(28, 32, 53)
    val copos = Array<Nieve>(200, { Nieve(this) })


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawColor(fondo)
        main.setTitle("Ancho: ${width}, Largo: ${height}")
        var p = Paint()
        p.color = Color.WHITE
        val ajusteY = 200f
        //Paisaje

        ///Nubes
        p.color = Color.WHITE
        for (sepX in (0..11))
            c.drawCircle(20f * sepX * 5f, 10f, 100f, p)
        //Montañas
        p.color = rgb(43, 89, 19)
        c.drawOval(-100f, 400f + ajusteY, 800f, 1400f + ajusteY, p)
        c.drawOval(600f, 400f + ajusteY, 1300f, 1400f + ajusteY, p)
        p.color = fondo
        c.drawRect(0f, 1200f + ajusteY, 1090f, 1400f + ajusteY, p)


        //Casa
        p.color = rgb(255, 172, 48)
        c.drawRect(400f, 800f + ajusteY, 1000f, 1200f + ajusteY, p)
        ///puerta
        p.color = rgb(66, 44, 12)
        c.drawRect(450f, 900f + ajusteY, 600f, 1200f + ajusteY, p)
        p.color = Color.LTGRAY
        c.drawCircle(560f, 1070f + ajusteY, 10f, p)
        ///Windows
        p.color = rgb(0, 188, 212)
        c.drawRect(750f, 900f + ajusteY, 900f, 1050f + ajusteY, p)

        //Piso
        p.color = rgb(230, 230, 230)
        c.drawRect(0f, 1200f + ajusteY, 1090f, 1900f + ajusteY, p)

        //Copos de Nieve
        (0..copos.size - 1).forEach {
            copos[it].mover()
            copos[it].pintar(c)


        }

    }

    fun rgb(r: Int, g: Int, b: Int): Int {
        return Color.rgb(r, g, b)
    }

    val corutina = GlobalScope.launch {

        while (true) {
            main.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }
}