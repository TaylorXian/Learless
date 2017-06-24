package org.xman.xland.core.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

/**
 * Created by xiandeb on 17/6/24.
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl implements JavaTypeResolver {

    public MyJavaTypeResolver() {
        super();
        typeMap.put(Types.INTEGER, new JdbcTypeInformation("INTEGER", //$NON-NLS-1$
            new FullyQualifiedJavaType(Long.class.getName())));
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
    }

    @Override
    public void setWarnings(List<String> warnings) {
        super.setWarnings(warnings);
    }

    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        System.out.println(introspectedColumn.toString());
        return super.calculateJavaType(introspectedColumn);
    }

    @Override
    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        return super.calculateJdbcTypeName(introspectedColumn);
    }
}
