package org.xman.lear.domain;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.id
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.title
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.author
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.content
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.ctime
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private String ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_comment.memo
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    private String memo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.id
     *
     * @return the value of x_comment.id
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.id
     *
     * @param id the value for x_comment.id
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.title
     *
     * @return the value of x_comment.title
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.title
     *
     * @param title the value for x_comment.title
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.author
     *
     * @return the value of x_comment.author
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.author
     *
     * @param author the value for x_comment.author
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.content
     *
     * @return the value of x_comment.content
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.content
     *
     * @param content the value for x_comment.content
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.ctime
     *
     * @return the value of x_comment.ctime
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.ctime
     *
     * @param ctime the value for x_comment.ctime
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_comment.memo
     *
     * @return the value of x_comment.memo
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_comment.memo
     *
     * @param memo the value for x_comment.memo
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}