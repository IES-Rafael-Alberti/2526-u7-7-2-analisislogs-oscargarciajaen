package org.iesra.Dominio

import java.io.File

class LogApp {

    fun ejecutar(){
        // Todo desarrollar la lógica.

        fun validarSalida(salida: String):String{
            val directorio = File(salida)
            directorio.parentFile?.mkdirs()
            directorio.writeText(//salida)
        }
    }
    
}