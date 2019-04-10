package com.jing.mapper;

import com.jing.bean.Department;
import org.apache.ibatis.annotations.*;
//指定这是一个操作数据库的mapper    注解版的mybatis
//@Mapper 给每个mapper文件单独加    或在Newspringboot04Application统一
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);
    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
