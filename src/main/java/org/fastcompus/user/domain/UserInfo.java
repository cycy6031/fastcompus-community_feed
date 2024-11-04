package org.fastcompus.user.domain;

public class UserInfo {

    private final String name;
    private final String profileImageUrl;

    public UserInfo(String name, String profileImageUrl) {
        if(name == null || profileImageUrl == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}
