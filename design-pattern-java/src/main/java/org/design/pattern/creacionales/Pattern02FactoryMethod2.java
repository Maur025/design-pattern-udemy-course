package org.design.pattern.creacionales;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * ! Factory Method: El patrón Factory Method permite crear objetos sin especificar la clase exacta
 * del objeto que se creará.
 * <p>
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos que encapsulan esta
 * lógica.
 * <p>
 * Es útil cuando una clase no puede anticipar la clase de objetos que debe crear.
 * <p>
 * <a href="https://refactoring.guru/es/design-patterns/factory-method">refactoring-guru</a>
 */

interface Report {

    void generate();
}

@Slf4j
public class Pattern02FactoryMethod2 {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        log.info("¿Que tipo de reporte deseas? (sales / inventory / accounting)");
        String reportType = scanner.nextLine();

        ReportFactory reportFactory = switch (reportType) {
            case "sales" -> new SalesReportFactory();
            case "inventory" -> new InventoryReportFactory();
            case "accounting" -> new AccountingReportFactory();
            default -> throw new IllegalArgumentException("Error... opcion no disponible");
        };

        reportFactory.generateReport();
    }
}

@Slf4j
class SalesReport implements Report {

    @Override
    public void generate() {
        log.info("Generando reporte de ventas...");
    }
}

@Slf4j
class InventoryReport implements Report {

    @Override
    public void generate() {
        log.info("Generando reporte de inventario...");
    }
}

@Slf4j
class AccountingReport implements Report {

    @Override
    public void generate() {
        log.info("Generando reporte de contabilidad...");
    }
}

abstract class ReportFactory {

    protected abstract Report createReport();

    public void generateReport() {
        Report report = createReport();
        report.generate();
    }
}

class SalesReportFactory extends ReportFactory {

    @Override
    protected Report createReport() {
        return new SalesReport();
    }
}

class InventoryReportFactory extends ReportFactory {

    @Override
    protected Report createReport() {
        return new InventoryReport();
    }
}

class AccountingReportFactory extends ReportFactory {

    @Override
    protected Report createReport() {
        return new AccountingReport();
    }
}