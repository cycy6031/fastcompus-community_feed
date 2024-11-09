package org.fastcampus.user.applicaion;

import org.fastcampus.user.applicaion.dto.FollowUserRequestDto;
import org.fastcampus.user.applicaion.inserfaces.UserRelationRepository;
import org.fastcampus.user.domain.User;

public class UserRelationService {
    private final UserService userService;
    private final UserRelationRepository userRelationRepository;

    public UserRelationService(UserService userService,
        UserRelationRepository userRelationRepository) {
        this.userService = userService;
        this.userRelationRepository = userRelationRepository;
    }

    public void follow(FollowUserRequestDto dto){
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(userRelationRepository.isAlreasyFollow(user, targetUser)){
            throw new IllegalArgumentException();
        }

        user.follow(targetUser);
        userRelationRepository.save(user, targetUser);
    }

    public void unfollow(FollowUserRequestDto dto){
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(!userRelationRepository.isAlreasyFollow(user, targetUser)){
            throw new IllegalArgumentException();
        }

        user.unfollow(targetUser);
        userRelationRepository.save(user, targetUser);
    }
}
