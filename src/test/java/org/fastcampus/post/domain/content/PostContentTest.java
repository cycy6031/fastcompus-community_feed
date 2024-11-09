package org.fastcampus.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PostContentTest {

    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent(){
        //given
        String text = "this is a test";

        //when
        PostContent content = new PostContent(text);

        //then
        assertEquals(text, content.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenThrowError(){
        //given
        String content = "a".repeat(501);
        
        //when, then
        assertThrows(IllegalArgumentException.class, ()->new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁", "닭", "굵", "삵", "슭"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord){
        //given
        String content = koreanWord.repeat(501);

        //when, then
        assertThrows(IllegalArgumentException.class, ()->new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError(){
        //given
        String content = "a".repeat(4);

        //when, then
        assertThrows(IllegalArgumentException.class, ()->new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String value){
        //when, then
        assertThrows(IllegalArgumentException.class, ()->new  PostContent(value));
    }

    @Test
    void givenContentLengthIsOk_whenUpdated_thenNotThrowError(){
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        postContent.updateContent("this is a updated content");
    }

    @Test
    void givenContentLengthIsOk_whenUpdated_thenReturnUpdatedContent(){
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when
        String updateContent = "this is a updated content";
        postContent.updateContent(updateContent);

        //then
        assertEquals(updateContent, postContent.contentText);
    }

    @Test
    void givenContentLengthIsUnder_whenUpdated_thenThrowError(){
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        String value = "a".repeat(4);
        assertThrows(IllegalArgumentException.class, ()-> postContent.updateContent(value));
    }
}
