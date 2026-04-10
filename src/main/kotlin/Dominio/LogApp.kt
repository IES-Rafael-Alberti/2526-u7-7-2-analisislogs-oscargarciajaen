package org.iesra.Dominio

import java.io.File

class LogApp {

    val procesadorLogs = ProcesadorDeLogs()

    fun ejecutar(args: Array<String>) {

        val parser = InputParser
        val configuracion = parser.procesarEntrada(args)
        if (configuracion.dateFrom != null || configuracion.dateTo != null) {
            val logsFiltradosPorFecha = procesadorLogs.filtrarPorFecha(configuracion.dateFrom, configuracion.dateTo)
        }
        val niveles = configuracion.levels
        if (niveles != null && niveles.isNotEmpty()) {
            val logsFiltradosPorNivel: MutableList<String> = procesadorLogs.filtrarPorNivel(niveles)
        }

        // todo hacer la interseccion de varias listas filtradas usando los sets (lo que pilla los comunes de todos)

        fun validarSalida(salida: String){
            val directorio = File(salida)
            directorio.parentFile?.mkdirs()
            directorio.writeText()
        }


    }
    
}