package org.fastcampus.user.applicaion.inserfaces;

import java.util.Optional;
import org.fastcampus.user.domain.User;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long id);

}
