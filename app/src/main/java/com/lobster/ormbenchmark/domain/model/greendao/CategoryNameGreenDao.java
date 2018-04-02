package com.lobster.ormbenchmark.domain.model.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by Lobster on 04.03.18.
 */

@Entity(indexes = {
        @Index(value = "languageCode, categoryTag", unique = true)
})
public class CategoryNameGreenDao {

    @Id(autoincrement = true)
    Long id;

    private String categoryTag;

    private String languageCode;

    private String name;

    @Keep
    public CategoryNameGreenDao(String categoryTag, String languageCode,
                                String name) {
        this.categoryTag = categoryTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 1732831604)
    public CategoryNameGreenDao(Long id, String categoryTag, String languageCode,
            String name) {
        this.id = id;
        this.categoryTag = categoryTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 1003949058)
    public CategoryNameGreenDao() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryTag() {
        return this.categoryTag;
    }

    public void setCategoryTag(String categoryTag) {
        this.categoryTag = categoryTag;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
