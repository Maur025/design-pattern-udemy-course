package creacionales01.pattern01

enum class OrderDirection {
    ASC, DESC
}

class QueryBuilder(
    private val table: String,
    private val fields: MutableList<String> = mutableListOf(),
    private val conditions: MutableList<String> = mutableListOf(),
    private val orderFields: MutableList<String> = mutableListOf(),
    private var limitCount: Int? = null
) {
    fun select(vararg fields: String): QueryBuilder {
        if (fields.isEmpty()) {
            this.fields.add("*")
            return this
        }

        this.fields.clear()
        this.fields.addAll(fields)
        return this
    }

    fun where(condition: String): QueryBuilder {
        conditions.add(condition)
        return this
    }

    fun orderBy(field: String, direction: OrderDirection): QueryBuilder {
        orderFields.clear()

        orderFields.add(field)
        orderFields.add(direction.toString())

        return this
    }

    fun limit(count: Int): QueryBuilder {
        limitCount = count
        return this
    }

    fun execute(): String {
        var query: String = "SELECT ${fields.joinToString(separator = ", ")} FROM $table"

        if (!conditions.isEmpty()) {
            query += " WHERE ${conditions.joinToString(separator = " AND ")}"
        }

        if (!orderFields.isEmpty()) {
            query += " ORDER BY ${orderFields.first()} ${orderFields[1]}"
        }

        if (limitCount != null) {
            query += " LIMIT $limitCount"
        }

        return "$query;"
    }
}

fun main() {
    val usersQuery: String =
        QueryBuilder(table = "Users").select("id", "name", "email").where("age > 18")
            .where("country = 'Cri'").orderBy("name", OrderDirection.ASC).limit(10).execute()

    println("Consulta:")
    println(usersQuery)
}