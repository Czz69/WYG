package world.com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import world.com.entity.IllnessKind;

/**
 * 疾病分类数据库访问
 *
 * @author XUEW
 */
@Repository
public interface IllnessKindDao extends BaseMapper<IllnessKind> {

}
