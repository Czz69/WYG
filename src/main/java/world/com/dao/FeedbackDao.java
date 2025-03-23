package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.Feedback;

//反馈数据库访问

@Repository
public interface FeedbackDao extends BaseMapper<Feedback> {

}
