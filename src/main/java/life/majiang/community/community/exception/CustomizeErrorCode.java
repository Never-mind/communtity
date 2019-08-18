package life.majiang.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的问题不存在了，要不换个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003,"未登录，请先进行登录"),
    SYS_ERROR(2004,"服务器异常"),
    TYPE_PARAM_WRONG(2005,"评论类型出错"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，要不换个试试");


    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
