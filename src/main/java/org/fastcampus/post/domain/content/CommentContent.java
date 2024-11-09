package org.fastcampus.post.domain.content;

public class CommentContent extends Content{

    private static final int MAX_CONTENT_LENGHT = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(contentText.length() > MAX_CONTENT_LENGHT){
            throw new IllegalArgumentException();
        }
    }

}