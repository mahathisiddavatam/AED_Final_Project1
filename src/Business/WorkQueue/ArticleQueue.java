/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class ArticleQueue {
    
    private ArrayList<Article> articlelist;

    public ArticleQueue() {
        articlelist = new ArrayList();
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
