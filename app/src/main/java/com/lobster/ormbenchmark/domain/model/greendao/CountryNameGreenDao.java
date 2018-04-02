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
        @Index(value = "languageCode, countyTag", unique = true)
})
public class CountryNameGreenDao {

    @Id(autoincrement = true)
    Long id;

    private String countyTag;

    private String languageCode;

    private String name;

    @Keep
    public CountryNameGreenDao(String countyTag, String languageCode,
                               String name) {
        this.countyTag = countyTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Keep
    public CountryNameGreenDao(String name) {
        this.name = name;
    }

    @Generated(hash = 1398880579)
    public CountryNameGreenDao(Long id, String countyTag, String languageCode,
            String name) {
        this.id = id;
        this.countyTag = countyTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 58550706)
    public CountryNameGreenDao() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountyTag() {
        return this.countyTag;
    }

    public void setCountyTag(String countyTag) {
        this.countyTag = countyTag;
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
