package org.fastcampus.user.applicaion.inserfaces;

import org.fastcampus.user.domain.User;

public interface UserRelationRepository {

    boolean isAlreasyFollow(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);
}
