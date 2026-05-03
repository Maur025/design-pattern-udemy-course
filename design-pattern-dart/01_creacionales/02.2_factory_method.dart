import 'dart:io';

void main() {
  stdout.write('¿Que tipo de reporte deseas? (sales / inventory/ accounting)');

  final String? reportType = stdin.readLineSync();

  final ReportFactory reportFactory = switch (reportType) {
    'sales' => SalesReportFactory(),
    'inventory' => InventoryReportFactory(),
    'accounting' => AccountingReportFactory(),
    _ => throw Exception('Error... opción no disponible'),
  };

  reportFactory.generateReport();
}

abstract class Report {
  void generate();
}

class SalesReport implements Report {
  @override
  void generate() {
    print('Generando reporte de ventas...');
  }
}

class InventoryReport implements Report {
  @override
  void generate() {
    print('Generando reporte de inventario...');
  }
}

class AccountingReport implements Report {
  @override
  void generate() {
    print('Generando reporte de contabilidad...');
  }
}

abstract class ReportFactory {
  Report createReport();

  void generateReport() {
    final Report report = createReport();
    report.generate();
  }
}

class SalesReportFactory extends ReportFactory {
  @override
  Report createReport() {
    return SalesReport();
  }
}

class InventoryReportFactory extends ReportFactory {
  @override
  Report createReport() {
    return InventoryReport();
  }
}

class AccountingReportFactory extends ReportFactory {
  @override
  Report createReport() {
    return AccountingReport();
  }
}
