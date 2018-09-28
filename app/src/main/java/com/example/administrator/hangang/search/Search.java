package com.example.administrator.hangang.search;

//어댑터에서 사용하는 한 아이템에 필요한 데이터를 다루는 객체
public class Search {
    String title;
    String content;
    int resId;
    int index;

    public Search(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Search(String title, String content, int resId, int index){
        this.title = title;
        this.content = content;
        this.resId = resId;
        this.index=index;

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
    public int getIndex(){return index;}
}
