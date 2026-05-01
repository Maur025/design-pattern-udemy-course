/**
 * ! Factory Method:
 * El patrón Factory Method permite crear objetos sin especificar
 * la clase exacta del objeto que se creará.
 *
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos
 * que encapsulan esta lógica.
 *
 * * Es útil cuando una clase no puede anticipar la clase
 * * de objetos que debe crear.
 *
 * https://refactoring.guru/es/design-patterns/factory-method
 */

/**
 * 	!Descripción:
  1.	Completen las clases SalesReport e InventoryReport para implementar 
      la interfaz Report, generando el contenido de cada reporte en el método generate.
	  
  2.	Implementen las clases SalesReportFactory e InventoryReportFactory 
      para crear instancias de SalesReport y InventoryReport, respectivamente.

	3.	Prueben el programa generando diferentes tipos de reportes usando
      el prompt para seleccionar el tipo de reporte.
 */

import * as rl from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";

class SalesReport {
	generate() {
		console.log("Generando reporte de ventas...");
	}
}

class InventoryReport {
	generate() {
		console.log("Generando reporte de inventario...");
	}
}

class AccountingReport {
	generate() {
		console.log("Generando reporte de contabilidad...");
	}
}

class ReportFactory {
	createReport() {}

	generateReport() {
		const report = this.createReport();
		report.generate();
	}
}

class SalesReportFactory extends ReportFactory {
	createReport() {
		return new SalesReport();
	}
}

class InventoryReportFactory extends ReportFactory {
	createReport() {
		return new InventoryReport();
	}
}

class AccountingReportFactory extends ReportFactory {
	createReport() {
		return new AccountingReport();
	}
}

async function main() {
	const readline = rl.createInterface({ input, output });
	const reportType = await readline.question(
		"¿Que tipo de reporte deseas? (sales / inventory/ accounting)",
	);

	let reportFactory;

	readline.close();

	switch (reportType) {
		case "sales": {
			reportFactory = new SalesReportFactory();
			break;
		}
		case "inventory": {
			reportFactory = new InventoryReportFactory();
			break;
		}
		case "accounting": {
			reportFactory = new AccountingReportFactory();
			break;
		}
		default: {
			throw new Error("Error ... opción no disponible");
		}
	}

	reportFactory.generateReport();
}

main();
