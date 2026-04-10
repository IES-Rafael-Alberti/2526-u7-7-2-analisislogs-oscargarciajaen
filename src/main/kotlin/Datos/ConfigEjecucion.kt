package org.iesra.Datos

import java.time.LocalDateTime

data class ConfigEjecucion(
    var dateFrom: LocalDateTime? = null,
    var dateTo: LocalDateTime? = null,
    var levels: MutableList<String>? = null,
    var report: Boolean? = null,
    var stats: Boolean? = null,
    var output: String? = null,
    var mostrarConsola: Boolean? = null,
)

