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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByStatus", 
                query = "SELECT a FROM Article a WHERE a.status = :status ORDER BY a.createdAt DESC"),
    @NamedQuery(name = "Article.findByCategory", 
                query = "SELECT a FROM Article a WHERE a.category.id = :categoryId AND a.status = 'APPROVED' ORDER BY a.createdAt DESC"),
    @NamedQuery(name = "Article.findByAuthor", 
                query = "SELECT a FROM Article a WHERE a.author.id = :authorId ORDER BY a.createdAt DESC")
})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    
    @NotNull
    @Lob
    @Column(length = 10000)
    private String content;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    private byte[] image;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    public Article() {
    }

    public Article(String title, String content, Category category, 
            User author, Date createdAt, Status status) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Article(String title, String content, Category category, 
            byte[] image, User author, Date createdAt, Status status) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.image = image;
        this.author = author;
        this.createdAt = createdAt;
        this.status = status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.southnews.Article[ id=" + id + " ]";
    }
    
}
