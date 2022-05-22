package net.stonegomes.commons.storage.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Query {

    private final String queryContent;
    private final Object[] values;

    public static QueryBuilder builder() {
        return new QueryBuilder();
    }

}
