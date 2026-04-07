package org.iesra.Dominio

class ProcesadorDeLogs() {

    val logs = FileManager.logs

    fun contadorEntradas(): Int {
        var entradas = 0
        for (i in logs){
            entradas += 1
        }
        return entradas
    }

    fun filtrarPorFecha(desde: String, hasta: String){
        // Todo filtrado por fecha
    }

    fun generarAnalisis(){
        // Todo generardor analisis
    }

}