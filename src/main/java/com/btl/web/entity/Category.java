package com.btl.web.entity;

import javax.persistence.*;
import java.text.Normalizer;
import java.util.regex.Pattern;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ParentId")
    private Integer parentId;

    @Column(name = "Name")
    private String name;

    public Integer getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }
    public String convertUriUrl() {
        try {
            String temp = Normalizer.normalize(this.name, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().trim().replaceAll(" ", "-").replaceAll("đ", "d").replaceAll(":", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
