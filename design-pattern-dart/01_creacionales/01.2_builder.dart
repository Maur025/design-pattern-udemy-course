void main() {
  final String usersQuery = QueryBuilder(table: 'users')
      .select(['id', 'name', 'email'])
      .where('age > 18')
      .where("country = 'Cri'")
      .orderBy('name', OrderDirection.ASC)
      .limit(10)
      .execute();

  print('Consulta:\n');
  print(usersQuery);
}

enum OrderDirection { ASC, DESC }

class QueryBuilder {
  final String _table;
  List<String> _fields;
  List<String> _conditions;
  List<String> _orderFields;
  int? _limitCount;

  QueryBuilder({required String table})
    : _table = table,
      _fields = [],
      _conditions = [],
      _orderFields = [];

  QueryBuilder select(List<String> fields) {
    if (fields.isEmpty) {
      _fields.add("*");
      return this;
    }

    _fields.addAll(fields);
    return this;
  }

  QueryBuilder where(String condition) {
    _conditions.add(condition);
    return this;
  }

  QueryBuilder orderBy(String field, OrderDirection direction) {
    _orderFields = [field, direction.name];
    return this;
  }

  QueryBuilder limit(int count) {
    _limitCount = count;
    return this;
  }

  String execute() {
    String query = 'SELECT ${_fields.join(", ")} FROM $_table';

    if (_conditions.isNotEmpty) {
      query += ' WHERE ${_conditions.join(' AND ')}';
    }

    if (_orderFields.isNotEmpty) {
      query += ' ORDER BY ${_orderFields.first} ${_orderFields[1]}';
    }

    if (_limitCount != null) {
      query += ' LIMIT $_limitCount';
    }

    return query;
  }
}
