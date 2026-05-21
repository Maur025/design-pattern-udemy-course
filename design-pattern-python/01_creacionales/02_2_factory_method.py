from abc import ABC, abstractmethod
from typing import Protocol


class Report(Protocol):
    def generate(self) -> None:
        ...


class SalesReport:
    def generate(self) -> None:
        print("Generando reporte de ventas...")


class InventoryReport:
    def generate(self) -> None:
        print("Generando reporte de inventario...")


class AccountingReport:
    def generate(self) -> None:
        print("Generando reporte de contabilidad...")


class ReportFactory(ABC):
    @abstractmethod
    def create_report(self) -> Report:
        ...

    def generate_report(self) -> None:
        report = self.create_report()
        report.generate()


class SalesReportFactory(ReportFactory):
    def create_report(self) -> Report:
        return SalesReport()


class InventoryReportFactory(ReportFactory):
    def create_report(self) -> Report:
        return InventoryReport()


class AccountingReportFactory(ReportFactory):
    def create_report(self) -> Report:
        return AccountingReport()


def main():
    report_factory: ReportFactory | None = None
    report_type: str = input("¿Qué tipo de reporte deseas? (sales / inventory / accounting)\n")

    match report_type.strip():
        case "sales":
            report_factory = SalesReportFactory()
        case "inventory":
            report_factory = InventoryReportFactory()
        case "accounting":
            report_factory = AccountingReportFactory()
        case _:
            raise Exception("Error... opción no disponible")

    if report_factory is None:
        raise Exception("No se encontro la fabrica")

    report_factory.generate_report()


main()
