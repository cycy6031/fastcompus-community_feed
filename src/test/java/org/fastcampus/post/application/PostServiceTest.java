package org.fastcampus.post.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.fastcampus.user.applicaion.UserService;
import org.fastcampus.user.applicaion.dto.CreateUserRequestDto;
import org.fastcampus.user.domain.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PostServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();
    private final PostService postService = FakeObjectFactory.getPostService();

    private final User user = userService.createUser(new CreateUserRequestDto("user1", ""));
    private final User otherUser = userService.createUser(new CreateUserRequestDto("user2", ""));

    private final CreatePostRequestDto dto = new CreatePostRequestDto(user.getId(), "this is test content", PostPublicationState.PUBLIC);

    @Test
    void givenPostRequestDto_whenCreate_thenReturnPost(){
        //when
        Post savedPost = postService.createPost(dto);

        //then
        Post post = postService.getPost(savedPost.getId());
        assertEquals(savedPost, post);
    }

    @Test
    void givenCreatePost_whenUpdate_thenReturnUpdatedPost(){
        //given
        Post savedPost = postService.createPost(dto);

        //when
        Post updatePost = postService.updatePost(savedPost.getId(), dto);

        //then
        assertEquals(savedPost.getId(), updatePost.getId());
        assertEquals(savedPost.getAuthor(), updatePost.getAuthor());
        assertEquals(savedPost.getContent(), updatePost.getContent());
    }

    @Test
    void givenCreatePost_whenLiked_thenReturnPostWithLike(){
        //given
        Post savedPost = postService.createPost(dto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);

        //then
        assertEquals(1, savedPost.getLikeCount());
    }

    @Test
    void givenCreatePost_whenLikedTwice_thenReturnPostWithLike(){
        //given
        Post savedPost = postService.createPost(dto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);
        postService.likePost(likeRequestDto);

        //then
        assertEquals(1, savedPost.getLikeCount());
    }
}
