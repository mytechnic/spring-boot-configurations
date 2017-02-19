package com.mytechnic.sample.persistence.type;

import com.mytechnic.sample.persistence.common.MapperEnumType;
import com.mytechnic.sample.persistence.common.MapperEnumTypeHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public enum UserGrade implements MapperEnumType {
    USER("유저"), ADMIN("관리자");

    private String title;

    @MappedTypes(UserGrade.class)
    public static class TypeHandler extends MapperEnumTypeHandler<UserGrade> {
        public TypeHandler() {
            super(UserGrade.class);
        }
    }
}
