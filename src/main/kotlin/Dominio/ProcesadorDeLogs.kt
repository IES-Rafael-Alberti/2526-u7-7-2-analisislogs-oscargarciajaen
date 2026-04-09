package org.iesra.Dominio

import org.iesra.Presentacion.ConsoleInput
import kotlin.math.log

class ProcesadorDeLogs() {

    val logs = FileManager.logs

    fun contadorEntradas(): Int {
        var entradas = 0
        for (i in logs){
            entradas += 1
        }
        return entradas
    }

    fun filtrarPorFecha(desde: String, hasta: String): MutableList<String>{

        val logsFiltrados = mutableListOf<String>()

        for (log in logs){
            val horaLog = log.substringAfter("[").substringBefore("]")
            if (horaLog >= desde && horaLog <= hasta ){
                logsFiltrados.add(log)
            }
        }
        return logsFiltrados
    }

    fun contarInfo(): Int{
        var contadorInfo = 0
        for (log in logs){
            if (log.contains("INFO")){
                contadorInfo++
            }
        }
        return contadorInfo
    }

    fun contarError(): Int{
        var contadorError = 0
        for (log in logs){
            if (log.contains("ERROR")){
                contadorError++
            }
        }
        return contadorError
    }

    fun contarWarning(): Int{
        var contadorWarning = 0
        for (log in logs){
            if (log.contains("WARNING")){
                contadorWarning++
            }
        }
        return contadorWarning
    }

    fun obtenerPrimeraEntrada(): String {
        val primeraEntrada = logs.first().substringAfter("[").substringBefore("]")
        return primeraEntrada
    }

    fun obtenerUltimaEntrada(): String {
        val ulimaEntrada = logs.last().substringAfter("[").substringBefore("]")
        return ulimaEntrada
    }

    fun generarAnalisis(){
        val entradas = contadorEntradas()
        val info = contarInfo()
        val errores = contarError()
        val warnings = contarWarning()
        val primeraEntrada = obtenerPrimeraEntrada()
        val ultimaEntrdada = obtenerUltimaEntrada()
        ConsoleInput.mostrarAnalisis(entradas, info, errores, warnings, primeraEntrada, ultimaEntrdada)
    }

}