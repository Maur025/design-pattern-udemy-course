/**
 * ! Patrón Builder:
 * Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 *
 * El patrón nos permite producir distintos tipos y representaciones
 * de un objeto empleando el mismo código de construcción.
 *
 * * Es útil cuando necesitamos construir un objeto complejo con muchas partes
 * * y queremos que el proceso de construcción sea independiente de las partes
 * * que lo componen.
 */

import { COLORS } from "../helpers/colors.ts";

//! Tarea: crear un QueryBuilder para construir consultas SQL
/**
 * Debe de tener los siguientes métodos:
 * - constructor(table: string)
 * - select(fields: string[]): QueryBuilder -- si no se pasa ningún campo, se seleccionan todos con el (*)
 * - where(condition: string): QueryBuilder - opcional
 * - orderBy(field: string, order: string): QueryBuilder - opcional
 * - limit(limit: number): QueryBuilder - opcional
 * - execute(): string - retorna la consulta SQL
 * 
 ** Ejemplo de uso:
  const usersQuery = new QueryBuilder("users") // users es el nombre de la tabla
    .select("id", "name", "email")
    .where("age > 18")
    .where("country = 'Cri'")
    .orderBy("name", "ASC")
    .limit(10)
    .execute();

  console.log('Consulta: ', usersQuery);
  // Select id, name, email from users where age > 18 and country = 'Cri' order by name ASC limit 10;
 */

//! Solución

class QueryBuilder {
	private readonly table: string;
	private fields: string[] = [];
	private readonly conditions: string[] = [];
	private orderFields: string[] = [];
	private limitCount?: number;

	constructor(table: string) {
		this.table = table;
	}

	select(...fields: string[]): this {
		if (!fields.length) {
			fields.push("*");
			return this;
		}

		this.fields = fields;
		return this;
	}

	where(condition: string): this {
		this.conditions.push(condition);
		return this;
	}

	orderBy(field: string, direction: "ASC" | "DESC" = "ASC"): this {
		this.orderFields = [field, direction];

		return this;
	}

	limit(count: number): this {
		this.limitCount = count;
		return this;
	}

	execute(): string {
		let query: string = `SELECT ${this.fields.join(", ")} FROM ${this.table}`;

		if (this.conditions.length) {
			query += ` WHERE ${this.conditions.join(" AND ")}`;
		}

		if (this.orderFields.length) {
			query += ` ORDER BY ${this.orderFields[0]} ${this.orderFields[1]}`;
		}

		if (this.limitCount) {
			query += ` LIMIT ${this.limitCount}`;
		}
		// Select id, name, email from users where age > 18 and country = 'Cri' order by name ASC limit 10;
		return `${query};`;
	}
}

function main() {
	const usersQuery = new QueryBuilder("users")
		.select("id", "name", "email")
		.where("age > 18")
		.where("country = 'Cri'") // Esto debe de hacer una condición AND
		.orderBy("name", "ASC")
		.limit(10)
		.execute();

	console.log("%cConsulta:\n", COLORS.red);
	console.log(usersQuery);
}

main();
