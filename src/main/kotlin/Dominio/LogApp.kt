package org.iesra.Dominio

import org.iesra.Escritor.Escritor
import org.iesra.Presentacion.Consola

class LogApp {

    val consola: Consola = Consola()

    val escritor = Escritor()

    val procesadorLogs = ProcesadorDeLogs()

    fun ejecutar(args: Array<String>) {

        val parser = InputParser()
        val configuracion = parser.procesarEntrada(args)
        if (configuracion.dateFrom != null || configuracion.dateTo != null) {
            val logsFiltradosPorFecha = procesadorLogs.filtrarPorFecha(configuracion.dateFrom, configuracion.dateTo)
            consola.mostrarLogsFiltradosPorFecha(logsFiltradosPorFecha)
        }
        val niveles = configuracion.levels
        if (niveles != null && niveles.isNotEmpty()) {
            val logsFiltradosPorNivel: MutableList<String> = procesadorLogs.filtrarPorNivel(niveles)
            consola.mostrarLogsFiltradosPorNivel(logsFiltradosPorNivel)
        }
        if (configuracion.report != null && configuracion.report != configuracion.stats ){
            val informeCompleto = procesadorLogs.generarInformeCompleto()
            if (configuracion.mostrarConsola == true) {
                consola.mostrarAnalisis()
            } else if (configuracion.output != null) {
                val salida = configuracion.output
                val informe = procesadorLogs.generarInformeCompleto()
                escritor.escribirInformeCompleto(salida, informe)
            }
        } else if (configuracion.report == null && configuracion.report != configuracion.stats ){
            val estadisticas = procesadorLogs.generarStats()
            if (configuracion.mostrarConsola == true) {
                consola.mostrarStats()
            } else if (configuracion.output != null) {
                val salida = configuracion.output
                val estadisticas = procesadorLogs.generarStats()
                escritor.escribirInformeCompleto(salida, estadisticas)
            }
        }


    }
    
}