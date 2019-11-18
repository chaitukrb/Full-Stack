package com.example.mailservice.model;

public class News {
    private Long id;
    private String content;
    private Long subid;

    public News(Long id,String content,Long subid) {
        this.id=id;
        this.content=content;
        this.subid=subid;
    }

    public News() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSubid() {
        return subid;
    }

    public void setSubid(Long subid) {
        this.subid = subid;
    }
}
