package com.nexters.rezoom.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.nexters.rezoom.domain.view.QuestionView;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by JaeeonJin on 2018-08-02.
 */
public class HashTag {
    @JsonView(QuestionView.Simple.class)
    @Getter @Setter
    private int hashtagId;

    @JsonView(QuestionView.Simple.class)
    @Getter @Setter
    private String hashtagKeyword;

    public HashTag(String hashtagKeyword) {
        this.hashtagKeyword = hashtagKeyword;
    }

    public HashTag(int hashtagId, String hashtagKeyword) {
        this.hashtagId = hashtagId;
        this.hashtagKeyword = hashtagKeyword;
    }

    @Override
    public boolean equals(Object obj) {
        HashTag hashTag = (HashTag) obj;
        return hashTag.getHashtagId() == this.getHashtagId() && hashTag.getHashtagKeyword().equals(this.hashtagKeyword);
    }
}
