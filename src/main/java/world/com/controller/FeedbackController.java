package world.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.com.entity.Feedback;

//反馈控制器
@RestController
@RequestMapping(value = "feedback")
public class FeedbackController extends BaseController<Feedback> {

}
