package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.Illness;

//疾病数据库访问

@Repository
public interface IllnessDao extends BaseMapper<Illness> {

}
