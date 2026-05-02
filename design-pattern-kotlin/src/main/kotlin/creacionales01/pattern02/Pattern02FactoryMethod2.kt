package creacionales01.pattern02

interface Report {
    fun generate();
}

class SalesReport : Report {
    override fun generate() {
        println("Generando reporte de ventas...")
    }
}

class InventoryReport : Report {
    override fun generate() {
        println("Generando reporte de inventarios...")
    }
}

class AccountingReport : Report {
    override fun generate() {
        println("Generando reporte de contabilidad...")
    }
}

abstract class ReportFactory {
    protected abstract fun createReport(): Report;

    fun generateReport() {
        val report = createReport()
        report.generate()
    }
}

class SalesReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return SalesReport()
    }
}

class InventoryReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return InventoryReport()
    }
}

class AccountingReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return AccountingReport()
    }
}

fun main() {
    println("¿Que tipo de reporte deseas? (sales / inventory / accounting)")
    val reportType = readln()

    val reportFactory: ReportFactory = when (reportType) {
        "sales" -> SalesReportFactory()
        "inventory" -> InventoryReportFactory()
        "accounting" -> AccountingReportFactory()
        else -> throw Exception("Error ... opcion no disponible")
    }

    reportFactory.generateReport()
}