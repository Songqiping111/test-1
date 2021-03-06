package com.bdqn.ls.pojo;

import javax.persistence.*;
import java.util.List;

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    private String pwd;

    private Integer levelid;

    public List<Searchlisi> getSearchlisiList() {
        return searchlisiList;
    }

    public void setSearchlisiList(List<Searchlisi> searchlisiList) {
        this.searchlisiList = searchlisiList;
    }

    private List<Searchlisi> searchlisiList;

    public List<Info> getLikes() {
        return likes;
    }

    public void setLikes(List<Info> likes) {
        this.likes = likes;
    }

    private List<Info> likes;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return levelid
     */
    public Integer getLevelid() {
        return levelid;
    }

    /**
     * @param levelid
     */
    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }
}