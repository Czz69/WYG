package world.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.com.entity.Medicine;


// 药品控制器

@RestController
@RequestMapping("medicine")
public class MedicineController extends BaseController<Medicine> {

}
