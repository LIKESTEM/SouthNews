/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author thabi
 */
@Entity
@Table(name = "COMMENTS")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByArticle", 
                query = "SELECT c FROM Comment c WHERE c.article.id = :articleId ORDER BY c.createdAt DESC"),
    @NamedQuery(name = "Comment.findByUser", 
                query = "SELECT c FROM Comment c WHERE c.user.id = :userId ORDER BY c.createdAt DESC")
})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @NotNull
    @Size(min = 1, max = 1000)
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt = new Date();

    public Comment() {
    }

    public Comment(Article article, User user, String content) {
        this.article = article;
        this.user = user;
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.southnews.entities.Comment[ id=" + id + " ]";
    }
    
}
