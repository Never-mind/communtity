package life.majiang.community.community.controller;


import life.majiang.community.community.dto.NotificationDTO;
import life.majiang.community.community.enums.NotificationTypeEnum;
import life.majiang.community.community.model.User;
import life.majiang.community.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String notification(HttpServletRequest request,
            @PathVariable("id") Long id){
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }

        //user传进去是为了验证是不是自己
        NotificationDTO notificationDTO =  notificationService.read(id,user);

        if (NotificationTypeEnum.REPLY_COMMAND.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOuterid();
        } else {
            return "redirect:/";
        }

    }
}
