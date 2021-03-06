package org.xman.xland.core.domain.auth;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.name
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.description
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.create_time
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private String createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.parent_id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column au_role.memo
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    private String memo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.id
     *
     * @return the value of au_role.id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.id
     *
     * @param id the value for au_role.id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.name
     *
     * @return the value of au_role.name
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.name
     *
     * @param name the value for au_role.name
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.description
     *
     * @return the value of au_role.description
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.description
     *
     * @param description the value for au_role.description
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.create_time
     *
     * @return the value of au_role.create_time
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.create_time
     *
     * @param createTime the value for au_role.create_time
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.parent_id
     *
     * @return the value of au_role.parent_id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.parent_id
     *
     * @param parentId the value for au_role.parent_id
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column au_role.memo
     *
     * @return the value of au_role.memo
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column au_role.memo
     *
     * @param memo the value for au_role.memo
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}