package org.fastcampus.user.applicaion.dto;

//자바 14이후부터 recode 클래스가 존재하는데 dto처럼 객체가 변수와 생성자, 게터, 이퀄스랑 해시코드 메소드 생성됨
public record CreateUserRequestDto(String name, String profileImageUrl) {

}
