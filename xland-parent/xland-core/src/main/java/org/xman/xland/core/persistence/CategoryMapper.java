package org.xman.xland.core.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.xman.xland.core.domain.Category;
import org.xman.xland.core.domain.CategoryExample;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int countByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int deleteByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Delete({
        "delete from x_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Insert({
        "insert into x_category (name, ctime, ",
        "parent_id, ctype, ",
        "memo)",
        "values (#{name,jdbcType=VARCHAR}, #{ctime,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{ctype,jdbcType=VARCHAR}, ",
        "#{memo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int insertSelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Select({
        "select",
        "id, name, ctime, parent_id, ctype, memo",
        "from x_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Category selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_category
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Update({
        "update x_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "ctype = #{ctype,jdbcType=VARCHAR},",
          "memo = #{memo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}