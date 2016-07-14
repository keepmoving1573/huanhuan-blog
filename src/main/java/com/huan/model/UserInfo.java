package com.huan.model;

import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    @Column(name = "net_name")
    private String netName;

    private String job;

    @Column(name = "family_native_place")
    private String familyNativePlace;

    private String mobile;

    private String email;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return net_name
     */
    public String getNetName() {
        return netName;
    }

    /**
     * @param netName
     */
    public void setNetName(String netName) {
        this.netName = netName;
    }

    /**
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return family_native_place
     */
    public String getFamilyNativePlace() {
        return familyNativePlace;
    }

    /**
     * @param familyNativePlace
     */
    public void setFamilyNativePlace(String familyNativePlace) {
        this.familyNativePlace = familyNativePlace;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}