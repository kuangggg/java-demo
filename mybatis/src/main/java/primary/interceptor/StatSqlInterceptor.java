package primary.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;

@Intercepts({
        @Signature(type = StatementHandler.class,
        method = "query", args = {Statement.class, ResultHandler.class})
})
public class StatSqlInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        try {
            return invocation.proceed();
        } finally {
            BoundSql boundSql = statementHandler.getBoundSql();

            System.out.println(boundSql);
        }
    }
}
