package world.com.service;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationOutput;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//智慧医生服务

@Service
public class ApiService {

    @Value("${ai-key}")
    private String apiKey;

    public String query(String queryMessage) {
        Constants.apiKey = apiKey;
        try {
            Generation gen = new Generation();
            MessageManager msgManager = new MessageManager(10);
            Message systemMsg = Message.builder().role(Role.SYSTEM.getValue()).content("假设你是一个拥有三十年经验的全科医生，现在我向你提出一些医学问题，你给出简短的回答，不回答与医学提问无关的问题，回答医学问题时，不需要给出多余的建议。示例1：输入：为什么已婚女性容易得妇科疾病？ 输出：:妇科病已婚女性的得病率是很高的，主要是夫妻生活上不注意卫生引起的，多见于性生活前没有洗手，手看上去是干净的，但指甲里会藏污纳垢。性生活以后没有及时排尿或清洗。男方有包皮过长，包茎，而他本人又不拘小节，这些都可以导致阴道炎或宫颈炎，这些病没有及时治疗又会上行感染引起盆腔炎等，只要平常注意夫妻间卫生，把身体抵抗力提高些，一般不会有妇科炎症的。" +
                    "示例2：输入：白带有些黄有些痒是宫颈靡烂吗？ 输出：白带有些黄有些痒并不一定是宫颈靡烂。宫颈靡烂是一种常见的宫颈炎症,通常表现为宫颈表面上皮细胞脱落和阴道分泌物增多。也可能是阴道炎所致。可以完善白带常规检查" +
                    "示例3： 输入：每天下午手脚发麻，浑身无力，输出：我考虑的是颈椎的疾病引起的，建议做个相关检查。" +
                    "示例4 输入：我以做过多次人流请问我怀孕的几率还有多少？ 输出：人流会对怀孕产生一定的影响,但具体影响的程度因人而异。多次人流可能会降低怀孕的几率,但其实只要自身恢复的好就没有问题不要担心。").build();
            Message userMsg = Message.builder().role(Role.USER.getValue()).content(queryMessage).build();
            msgManager.add(systemMsg);
            msgManager.add(userMsg);
            QwenParam param = QwenParam.builder().model(Generation.Models.QWEN_TURBO).messages(msgManager.get()).resultFormat(QwenParam.ResultFormat.MESSAGE).build();
            GenerationResult result = gen.call(param);
            GenerationOutput output = result.getOutput();
            Message message = output.getChoices().get(0).getMessage();
            return message.getContent();
        } catch (Exception e) {
            return "智能医生现在不在线，请稍后再试～";
        }
    }
}
