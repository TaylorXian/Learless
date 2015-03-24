package org.xman.lear.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.xman.lear.domain.Article;
import org.xman.lear.domain.ArticleExample;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    @Delete({
        "delete from x_article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    @Insert({
        "insert into x_article (title, author, ",
        "content, ctime, ",
        "parent_id, memo)",
        "values (#{title,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{ctime,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{memo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    @Select({
        "select",
        "id, title, author, content, ctime, parent_id, memo",
        "from x_article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Article selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_article
     *
     * @mbggenerated Sun Mar 22 21:57:23 CST 2015
     */
    @Update({
        "update x_article",
        "set title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "memo = #{memo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Article record);
}