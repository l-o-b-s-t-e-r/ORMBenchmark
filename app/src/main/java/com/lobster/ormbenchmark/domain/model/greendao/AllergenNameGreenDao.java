package com.lobster.ormbenchmark.domain.model.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Keep;

@Entity(indexes = {
        @Index(value = "languageCode, allergenTag", unique = true)
})
public class AllergenNameGreenDao {

    @Id(autoincrement = true)
    Long id;

    private String allergenTag;

    private String languageCode;

    private String name;

    @Keep
    public AllergenNameGreenDao(String allergenTag, String languageCode,
                                String name) {
        this.allergenTag = allergenTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 2024723149)
    public AllergenNameGreenDao(Long id, String allergenTag, String languageCode,
            String name) {
        this.id = id;
        this.allergenTag = allergenTag;
        this.languageCode = languageCode;
        this.name = name;
    }

    @Generated(hash = 1442646670)
    public AllergenNameGreenDao() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergenTag() {
        return this.allergenTag;
    }

    public void setAllergenTag(String allergenTag) {
        this.allergenTag = allergenTag;
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
