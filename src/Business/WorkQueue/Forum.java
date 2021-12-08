/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Varakumar
 */
public class Forum {
    
    int id;
    int count =1;
    private ArrayList <Article> articlelist;
    String title;
    String description;
    String createdby;
    Date date;

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    private ArrayList <String> studentidlist;
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void Forum(){
        
        
        articlelist = new ArrayList();
        studentidlist = new ArrayList();
    }

    public ArrayList<String> getStudentidlist() {
        return studentidlist;
    }

    public void setStudentidlist(ArrayList<String> studentidlist) {
        this.studentidlist = studentidlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Article> getArticlelist() {
        return articlelist;
    }

    public void setArticlelist(ArrayList<Article> articlelist) {
        this.articlelist = articlelist;
    }
    
    public Article addArticle(){
        
        Article article = new Article();
        articlelist.add(article);
        return article;
        
    }
    
    public Article retrieveArticle(int id){
        
        for(Article article: articlelist){
            
            if(article.getId()==id){
                return article;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteArticle(int id){
        
        Article article = retrieveArticle(id);
        if(article==null){
            
            return false;
        }
        articlelist.remove(article);
        return true;
        
        
        
    }
    
    
    
}
