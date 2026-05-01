package org.design.pattern.creacionales.pattern01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * ! Patrón Builder: Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 * <p>
 * El patrón nos permite producir distintos tipos y representaciones de un objeto empleando el mismo
 * código de construcción.
 * <p>
 * Es útil cuando necesitamos construir un objeto complejo con muchas partes y queremos que el
 * proceso de construcción sea independiente de las partes que lo componen.
 */

enum OrderDirection {
    ASC, DESC
}

@Slf4j
public class Pattern01Builder2 {

    static void main(String[] args) {
        var usersQuery = new QueryBuilder("users").select("id", "name", "email")
            .where("age > 18")
            .where("country = 'Cri'")
            .orderBy("name", OrderDirection.ASC)
            .limit(10)
            .execute();

        log.info("Consulta: {}", usersQuery);
    }
}

@Getter
@Setter
class QueryBuilder {

    private String table;
    private List<String> fields = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();
    private List<String> orderFields = new ArrayList<>();
    private Integer limitCount;

    public QueryBuilder(String table) {
        this.table = table;
    }

    public QueryBuilder select(String... fieldArray) {
        if (fieldArray == null) {
            return this;
        }

        if (fieldArray.length == 0) {
            this.fields.add("*");
            return this;
        }

        this.fields = Arrays.stream(fieldArray)
            .toList();

        return this;
    }

    public QueryBuilder where(String condition) {
        this.conditions.add(condition);

        return this;
    }

    public QueryBuilder orderBy(String field, OrderDirection direction) {
        if (direction == null) {
            direction = OrderDirection.ASC;
        }

        this.orderFields.add(field);
        this.orderFields.add(direction.toString());

        return this;
    }

    public QueryBuilder limit(Integer count) {
        this.limitCount = count;

        return this;
    }

    public String execute() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ")
            .append(String.join(", ", this.fields))
            .append(" FROM ")
            .append(this.table);

        if (!this.conditions.isEmpty()) {
            query.append(" WHERE ")
                .append(String.join(" AND ", this.conditions));
        }

        if (!this.orderFields.isEmpty()) {
            query.append(" ORDER BY ")
                .append(this.orderFields.getFirst())
                .append(" ")
                .append(this.orderFields.get(1));
        }

        if (this.limitCount != null) {
            query.append(" LIMIT ")
                .append(this.limitCount);
        }

        return query.append(";").toString();
    }
}
