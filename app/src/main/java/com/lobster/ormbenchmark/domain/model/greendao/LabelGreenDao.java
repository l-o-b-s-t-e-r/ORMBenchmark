package com.lobster.ormbenchmark.domain.model.greendao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by Lobster on 03.03.18.
 */

@Entity(indexes = {
        @Index(value = "tag", unique = true)
})
public class LabelGreenDao {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String tag;

    @ToMany(joinProperties = {
            @JoinProperty(name = "tag", referencedName = "labelTag")
    })
    private List<LabelNameGreenDao> names;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2068911685)
    private transient LabelGreenDaoDao myDao;

    public LabelGreenDao() {
    }

    @Keep
    public LabelGreenDao(String tag, List<LabelNameGreenDao> names) {
        this.tag = tag;
        this.names = names;
    }

    @Generated(hash = 675618046)
    public LabelGreenDao(Long id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1973467237)
    public List<LabelNameGreenDao> getNames() {
        if (names == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LabelNameGreenDaoDao targetDao = daoSession.getLabelNameGreenDaoDao();
            List<LabelNameGreenDao> namesNew = targetDao._queryLabelGreenDao_Names(tag);
            synchronized (this) {
                if (names == null) {
                    names = namesNew;
                }
            }
        }
        return names;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1832659617)
    public synchronized void resetNames() {
        names = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1625307560)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLabelGreenDaoDao() : null;
    }
}
