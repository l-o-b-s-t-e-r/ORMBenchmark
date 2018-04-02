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
        @Index(value = "languageCode, additiveTag", unique = true)
})
public class AdditiveNameGreenDao {

    @Id(autoincrement = true)
    Long id;

    private String additiveTag;

    private String languageCode;

    private String name;

    @Keep
    public AdditiveNameGreenDao(String additiveTag, String languageCode,
                                String name) {
        this.additiveTag = additiveTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Keep
    public AdditiveNameGreenDao(String name) {
        this.name = name;
    }

    @Generated(hash = 391609571)
    public AdditiveNameGreenDao(Long id, String additiveTag, String languageCode,
            String name) {
        this.id = id;
        this.additiveTag = additiveTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 1676962984)
    public AdditiveNameGreenDao() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdditiveTag() {
        return this.additiveTag;
    }

    public void setAdditiveTag(String additiveTag) {
        this.additiveTag = additiveTag;
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
