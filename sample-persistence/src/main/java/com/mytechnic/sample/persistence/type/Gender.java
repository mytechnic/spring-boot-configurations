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
public enum Gender implements MapperEnumType<Gender> {
    MALE("남성"), FEMALE("여성"),;

    private String title;

    @MappedTypes(UserGrade.class)
    public static class TypeHandler extends MapperEnumTypeHandler<UserGrade> {
        public TypeHandler() {
            super(UserGrade.class);
        }
    }
}
