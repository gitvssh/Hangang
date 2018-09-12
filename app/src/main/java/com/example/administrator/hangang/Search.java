package com.example.administrator.hangang;

public class Search {
    String title;
    String content;
    int resId;

    public Search(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Search(String title, String content, int resId){
        this.title = title;
        this.content = content;
        this.resId = resId;

    }

    public int getResId(){
        return resId;
    }

    public void setResId(int resId){
        this.resId = resId;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
