package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.IllnessMedicine;

//疾病药品数据库访问

@Repository
public interface IllnessMedicineDao extends BaseMapper<IllnessMedicine> {

}
