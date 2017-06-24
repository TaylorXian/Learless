package org.xman.xland.core.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.xman.xland.core.domain.Association;
import org.xman.xland.core.domain.AssociationExample;

public interface AssociationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int countByExample(AssociationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int deleteByExample(AssociationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Delete({
        "delete from x_association",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Insert({
        "insert into x_association (sender_id, sender_name, ",
        "receiver_id, receiver_name, ",
        "comment_id, article_id, ",
        "category, memo)",
        "values (#{senderId,jdbcType=INTEGER}, #{senderName,jdbcType=VARCHAR}, ",
        "#{receiverId,jdbcType=INTEGER}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{commentId,jdbcType=INTEGER}, #{articleId,jdbcType=INTEGER}, ",
        "#{category,jdbcType=VARCHAR}, #{memo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Association record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int insertSelective(Association record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    List<Association> selectByExample(AssociationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Select({
        "select",
        "id, sender_id, sender_name, receiver_id, receiver_name, comment_id, article_id, ",
        "category, memo",
        "from x_association",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Association selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") Association record, @Param("example") AssociationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExample(@Param("record") Association record, @Param("example") AssociationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByPrimaryKeySelective(Association record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_association
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Update({
        "update x_association",
        "set sender_id = #{senderId,jdbcType=INTEGER},",
          "sender_name = #{senderName,jdbcType=VARCHAR},",
          "receiver_id = #{receiverId,jdbcType=INTEGER},",
          "receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "comment_id = #{commentId,jdbcType=INTEGER},",
          "article_id = #{articleId,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR},",
          "memo = #{memo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Association record);
}