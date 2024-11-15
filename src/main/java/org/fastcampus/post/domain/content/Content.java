package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.common.DatetimeInfo;

public abstract class Content {
    protected String contentText;
    protected final DatetimeInfo datetimeInfo;

    Content(String contentText){
        checkText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    public void updateContent(String updatContent){
        checkText(updatContent);
        this.contentText = updatContent;
        this.datetimeInfo.updateEditDatetime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
