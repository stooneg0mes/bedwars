package net.stonegomes.commons.storage.query;

public class QueryBuilder {

    private String query;
    private Object[] values;

    public QueryBuilder query(String query) {
        this.query = query;
        return this;
    }

    public QueryBuilder values(Object... values) {
        this.values = values;
        return this;
    }

    public Query build() {
        return new Query(query, values);
    }

}
