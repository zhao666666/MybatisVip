package com.boge.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZhaoJie
 * @date 2024/6/27 19:38
 */
public class MyTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("---------------setNonNullParameter1："+parameter);
        preparedStatement.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        if("zhangsan".equals(name)){
            return name+"666";
        }
        return name;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
