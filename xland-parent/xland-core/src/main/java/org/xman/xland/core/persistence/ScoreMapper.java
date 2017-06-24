package org.xman.xland.core.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.xman.xland.core.domain.Score;
import org.xman.xland.core.domain.ScoreExample;

public interface ScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int countByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int deleteByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Delete({
        "delete from x_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Insert({
        "insert into x_score (data_id, name, ",
        "ctime, point, memo)",
        "values (#{dataId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{ctime,jdbcType=VARCHAR}, #{point,jdbcType=FLOAT}, #{memo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Score record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int insertSelective(Score record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    List<Score> selectByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Select({
        "select",
        "id, data_id, name, ctime, point, memo",
        "from x_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Score selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    int updateByPrimaryKeySelective(Score record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_score
     *
     * @mbggenerated Sat Jun 24 15:48:18 CST 2017
     */
    @Update({
        "update x_score",
        "set data_id = #{dataId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=VARCHAR},",
          "point = #{point,jdbcType=FLOAT},",
          "memo = #{memo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Score record);
}