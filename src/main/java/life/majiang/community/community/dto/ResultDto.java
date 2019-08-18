package life.majiang.community.community.dto;

import life.majiang.community.community.exception.CustomizeErrorCode;
import life.majiang.community.community.exception.CustomizeException;
import lombok.Data;

@Data
public class ResultDto {
    private Integer code;
    private String message;

    public static ResultDto errorOf(Integer code,String message){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(code);
        resultDto.setMessage(message);
        return resultDto;
    }

    public static ResultDto errorOf(CustomizeErrorCode customizeErrorCode) {
        return errorOf(customizeErrorCode.getCode(),customizeErrorCode.getMessage());
    }

    public static ResultDto errorOf(CustomizeException ex) {
        return errorOf(ex.getCode(),ex.getMessage());
    }

    public static ResultDto okOf(){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        return resultDto;
    }
}
