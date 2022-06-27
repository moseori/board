package me.light.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper1 {
	@Insert("insert into tb_sp1 (col) values (#{data})")
	public int insertCol(String data);
}
