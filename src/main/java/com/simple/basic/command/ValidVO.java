package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {

	/*
	 * @NotNull - null값만 허용하지 않는다(wrapper의 integet,Long, String 등등)
	 * @NotBlank - null값과 공백을 허용하지 않음(String에만 적용)
	 * @NotEmpty - null값을 허용하지 않음(Array,list 적용)
	 * @Pattern - 정규표현식에 맞는 문자열을 정의할 수 있음.
	 * 
	 * @Email - 이메일형식 검증 (공백은 통과)
	 * @Min - 최소값 검증
	 * @Max - 최대값 검증
	 * 
	 */
	
	@NotBlank(message = "이름은 필수입니다.")
	private String name;
	
	//숫자,실수형의 원시타입은 기본값이 0이라서 공백맵핑이 불가능하기때문에 래퍼타입으로 선언하는 편이 좋습니다.
	@NotNull(message = "급여는 필수입니다.")
	private Integer salary;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}",message = "전화번호형식은 000-0000-0000입니다" )
	private String phone;
	
	@NotBlank
	@Email(message = "이메일 형식이어야 합니다.") //eamil형식이어야 합니다. 단 공백은 통과
	private String email;
}
