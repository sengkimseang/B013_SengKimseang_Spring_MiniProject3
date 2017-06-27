package org.krd.khmer.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.krd.khmer.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {

	//@Results(value={@org.apache.ibatis.annotations.Result(property="date", column="created_date")})

	
	@Select("select * from testuser where status='true' order by id asc")
	public List<User> findAll();
	
	@Insert("INSERT INTO testuser("
			+"id, "
			+"username,"
			+"email,"
			+"gender,"
			+"phonenumber,"
			+"status,user_hash"
			+") VALUES("
			+ "#{user.id},"
			+"#{user.username},"
			+"#{user.email},"
			+"#{user.gender},"
			+"#{user.phonenumber},"
			+"#{user.status},"
			+"#{user.user_hash}"
			+")")
	
	public boolean save(@Param("user") User user);
	
	
	@Select ("select username,email,gender,phonenumber,status, user_hash from testuser where user_hash=#{user_hash}")
	public User findOne(@Param("user_hash") String user_hash);
	
	@Select ("select * from testuser where user_hash=#{user_hash} ")
	public User detail(@Param("user_hash") String user_hash);
	
	
	@Update("update testuser set username=#{user.username},email=#{user.email},gender=#{user.gender},phonenumber=#{user.phonenumber},status=#{user.status} where user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	
	@Delete("Update testuser set status='false' where user_hash= #{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
}
