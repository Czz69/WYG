package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.Pageview;

//分页数据库访问

@Repository
public interface PageviewDao extends BaseMapper<Pageview> {

}
