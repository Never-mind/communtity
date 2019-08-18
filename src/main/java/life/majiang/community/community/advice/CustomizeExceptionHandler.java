package life.majiang.community.community.advice;

import com.alibaba.fastjson.JSON;
import life.majiang.community.community.dto.ResultDto;
import life.majiang.community.community.exception.CustomizeErrorCode;
import life.majiang.community.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response){

        String contentType = request.getContentType();
        if("application/json".equals(contentType)){
            ResultDto resultDto;
            if(ex instanceof CustomizeException){
                resultDto =  ResultDto.errorOf((CustomizeException)ex);
            }else {
                resultDto = ResultDto.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDto));
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return null;

        }else{
            if(ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else {
                model.addAttribute("message","服务器冒烟了，请稍后重试！！！");
            }
            return new ModelAndView("error");
        }

    }
}
