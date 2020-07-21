package com.btl.web.entity;


import javax.persistence.*;

@Entity
@Table(name = "userweb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    @Column(name = "useremail")
    private String useremail;

    @Column(name = "userpassword")
    private String userpassword;

    @Column(name = "username")
    private String username;

    @Column(name = "birthday")
    private String brithday;

    @Column(name = "user_role")
    private Integer user_role;

    @Column(name = "avatar")
    private String avatar;

    public Integer getUserid () {
        return userid;
    }

    public void setUserid ( Integer userid ) {
        this.userid = userid;
    }

    public String getUseremail () {
        return useremail;
    }

    public void setUseremail ( String useremail ) {
        this.useremail = useremail;
    }

    public String getUserpassword () {
        return userpassword;
    }

    public void setUserpassword ( String userpassword ) {
        this.userpassword = userpassword;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getBrithday () {
        return brithday;
    }

    public void setBrithday ( String brithday ) {
        this.brithday = brithday;
    }

    public Integer getUser_role () {
        return user_role;
    }

    public void setUser_role ( Integer user_role ) {
        this.user_role = user_role;
    }

    public String getAvatar () {
        return avatar;
    }

    public void setAvatar ( String avatar ) {
        this.avatar = avatar;
    }
}
