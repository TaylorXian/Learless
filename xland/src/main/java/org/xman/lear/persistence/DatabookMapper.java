package org.xman.lear.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.xman.lear.domain.Databook;
import org.xman.lear.domain.DatabookExample;

public interface DatabookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int countByExample(DatabookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int deleteByExample(DatabookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    @Delete({
        "delete from x_databook",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    @Insert({
        "insert into x_databook (item_id, ctime, ",
        "ntime, no, delay, ",
        "pause, memo)",
        "values (#{itemId,jdbcType=INTEGER}, #{ctime,jdbcType=VARCHAR}, ",
        "#{ntime,jdbcType=VARCHAR}, #{no,jdbcType=INTEGER}, #{delay,jdbcType=VARCHAR}, ",
        "#{pause,jdbcType=INTEGER}, #{memo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Databook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int insertSelective(Databook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    List<Databook> selectByExample(DatabookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    @Select({
        "select",
        "id, item_id, ctime, ntime, no, delay, pause, memo",
        "from x_databook",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Databook selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int updateByExampleSelective(@Param("record") Databook record, @Param("example") DatabookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int updateByExample(@Param("record") Databook record, @Param("example") DatabookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    int updateByPrimaryKeySelective(Databook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x_databook
     *
     * @mbggenerated Tue Apr 07 17:02:42 CST 2015
     */
    @Update({
        "update x_databook",
        "set item_id = #{itemId,jdbcType=INTEGER},",
          "ctime = #{ctime,jdbcType=VARCHAR},",
          "ntime = #{ntime,jdbcType=VARCHAR},",
          "no = #{no,jdbcType=INTEGER},",
          "delay = #{delay,jdbcType=VARCHAR},",
          "pause = #{pause,jdbcType=INTEGER},",
          "memo = #{memo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Databook record);
}