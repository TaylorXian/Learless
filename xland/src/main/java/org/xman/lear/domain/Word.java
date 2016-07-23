package org.xman.lear.domain;

public class Word {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.text
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String text;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.phonetic
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String phonetic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.trans
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String trans;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.ctime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.ltime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String ltime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.count
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x_word.category_id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    private String categoryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.id
     *
     * @return the value of x_word.id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.id
     *
     * @param id the value for x_word.id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.text
     *
     * @return the value of x_word.text
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.text
     *
     * @param text the value for x_word.text
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.phonetic
     *
     * @return the value of x_word.phonetic
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getPhonetic() {
        return phonetic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.phonetic
     *
     * @param phonetic the value for x_word.phonetic
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic == null ? null : phonetic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.trans
     *
     * @return the value of x_word.trans
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getTrans() {
        return trans;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.trans
     *
     * @param trans the value for x_word.trans
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setTrans(String trans) {
        this.trans = trans == null ? null : trans.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.ctime
     *
     * @return the value of x_word.ctime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.ctime
     *
     * @param ctime the value for x_word.ctime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.ltime
     *
     * @return the value of x_word.ltime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getLtime() {
        return ltime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.ltime
     *
     * @param ltime the value for x_word.ltime
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setLtime(String ltime) {
        this.ltime = ltime == null ? null : ltime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.count
     *
     * @return the value of x_word.count
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.count
     *
     * @param count the value for x_word.count
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x_word.category_id
     *
     * @return the value of x_word.category_id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x_word.category_id
     *
     * @param categoryId the value for x_word.category_id
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }
}