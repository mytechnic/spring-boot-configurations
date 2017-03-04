package com.mytechnic.sample.persistent.type;

import com.mytechnic.sample.persistent.common.MapperEnumType;
import com.mytechnic.sample.persistent.common.MapperEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@AllArgsConstructor
@Getter
public enum UserStatus implements MapperEnumType {
	NORMAL("정상"), WITHDRAW_REQUEST("탈퇴요청"), WITHDRAW("탈퇴"), BLOCK("차단");

	private String title;

	@MappedTypes(UserStatus.class)
	public static class TypeHandler extends MapperEnumTypeHandler<UserStatus> {
		public TypeHandler() {
			super(UserStatus.class);
		}
	}
}
