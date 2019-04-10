package com.jing.mapper;

import com.jing.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
