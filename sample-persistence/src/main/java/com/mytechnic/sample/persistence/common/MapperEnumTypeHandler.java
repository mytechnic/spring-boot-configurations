package com.mytechnic.sample.persistence.common;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
public class MapperEnumTypeHandler<E extends Enum<E>> implements TypeHandler<MapperEnumType> {

    private Class<E> type;

    public MapperEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, MapperEnumType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public MapperEnumType getResult(ResultSet rs, String columnName) throws SQLException {
        return getMapperEnumType(rs.getString(columnName));
    }

    @Override
    public MapperEnumType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getMapperEnumType(rs.getString(columnIndex));
    }

    @Override
    public MapperEnumType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getMapperEnumType(cs.getString(columnIndex));
    }

    private MapperEnumType getMapperEnumType(String code) {
        if (code == null) {
            return null;
        }

        MapperEnumType[] enumConstants = (MapperEnumType[]) type.getEnumConstants();
        for (MapperEnumType MapperEnumType : enumConstants) {
            if (code.equalsIgnoreCase(MapperEnumType.name())) {
                return MapperEnumType;
            }
        }

        throw new IllegalArgumentException();
    }
}
