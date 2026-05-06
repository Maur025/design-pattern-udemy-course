from enum import Enum


class SortDirection(Enum):
    ASC = "ASC"
    DESC = "DESC"


class QueryBuilder:
    def __init__(self, table):
        self.table: str = table
        self.fields: list[str] = []
        self.conditions: list[str] = []
        self.order_fields: list[str] = []
        self.limit_count: int | None = None

    def select(self, fields: list[str]) -> QueryBuilder:
        if len(fields) < 1:
            self.fields.append("*")
            return self

        self.fields = fields
        return self

    def where(self, condition: str) -> QueryBuilder:
        self.conditions.append(condition)
        return self

    def order_by(self, field: str, direction: SortDirection) -> QueryBuilder:
        self.order_fields.append(field)
        self.order_fields.append(direction.value)
        return self

    def limit(self, count: int) -> QueryBuilder:
        self.limit_count = count
        return self

    def execute(self) -> str:
        query: str = f"SELECT {str.join(', ', self.fields)} FROM {self.table}"

        if len(self.conditions) > 0:
            query += f" WHERE {str.join(' AND ', self.conditions)}"

        if len(self.order_fields) > 0:
            query += f" ORDER BY {self.order_fields[0]} {self.order_fields[1]}"

        if self.limit_count is not None:
            query += f" LIMIT {self.limit_count}"

        return f"{query};"


def main():
    users_query = (QueryBuilder("users").select(["id", "name", "email"])
                   .where("age > 18")
                   .where("country = 'Cri'")
                   .order_by("name", SortDirection.ASC)
                   .limit(10)
                   .execute())

    print("Consulta:\n")
    print(users_query)


main()
