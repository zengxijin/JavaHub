package com.bkjk.credit.risk.qb;

import java.util.Map;

/**
 * @author zengxijin
 * This the top level API design for Query Builder executor
 * depends on the specific implementation for parse the query builder expression
 */
public interface QueryExecutor<T> {

    T execute(final Map<String, Object> context, String exp);
}
