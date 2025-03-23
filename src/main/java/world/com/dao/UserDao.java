package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.User;

// 用户数据库访问

@Repository
public interface UserDao extends BaseMapper<User> {

}
