package org.fastcampus.user.application;

import java.util.Optional;
import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.user.applicaion.UserService;
import org.fastcampus.user.applicaion.dto.CreateUserRequestDto;
import org.fastcampus.user.applicaion.inserfaces.UserRepository;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.fastcampus.user.repository.FakeUserRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();

    @Test
    void givenUserInfo_whenCreateUser_thenCanFindUser(){
        //given
        CreateUserRequestDto dto = new CreateUserRequestDto("test", "");

        //when
        User saveUser = userService.createUser(dto);

        //then
        User foundUser = userService.getUser(saveUser.getId());
        UserInfo userInfo = foundUser.getInfo();
        assertEquals(foundUser.getId(), saveUser.getId());
        assertEquals("test", userInfo.getName());
    }
}
