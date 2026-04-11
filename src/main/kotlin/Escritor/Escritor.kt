package org.iesra.Escritor

import org.iesra.Dominio.InputParser
import org.iesra.Dominio.ProcesadorDeLogs
import java.io.File

class Escritor {

    val parser: InputParser = InputParser()

    val procesadorLogs = ProcesadorDeLogs()

    fun escribirInformeCompleto(salida: String?, informe: MutableMap<String, String>){
        if (salida != null){
            val directorio = File(salida)
            directorio.parentFile?.mkdirs()
            directorio.appendText("INFORME DE LOGS")
            directorio.appendText("===============\n")
            directorio.appendText("RangoAplicado -> " + procesadorLogs.informeLog["primerLog"] + "-" + procesadorLogs.informeLog["ultimoLog"])
            directorio.appendText("Niveles incluidos -> " + procesadorLogs.informeLog["nivelesIncluidos"])
            directorio.appendText("Lineas procesadas -> " + procesadorLogs.informeLog["lineasProcesadas"])
            directorio.appendText("INFO -> " + procesadorLogs.informeLog["INFO"])
            directorio.appendText("WARNING -> " + procesadorLogs.informeLog["WARNING"])
            directorio.appendText("ERROR -> " + procesadorLogs.informeLog["ERROR"])
        }
    }

    fun escribirInformeStats(salida: String, informe: MutableMap<String, String>){
        val directorio = File(salida)
        directorio.parentFile?.mkdirs()
        directorio.appendText("INFORME DE LOGS")
        directorio.appendText("===============\n")
        directorio.appendText("Lineas procesadas -> " + procesadorLogs.informeLog["lineasProcesadas"])
        directorio.appendText("INFO -> " + procesadorLogs.informeLog["INFO"])
        directorio.appendText("WARNING -> " + procesadorLogs.informeLog["WARNING"])
        directorio.appendText("ERROR -> " + procesadorLogs.informeLog["ERROR"])
    }
}