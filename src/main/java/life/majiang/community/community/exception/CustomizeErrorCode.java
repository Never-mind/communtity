package life.majiang.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的问题不存在了，要不换个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003,"未登录，请先进行登录"),
    SYS_ERROR(2004,"服务器异常"),
    TYPE_PARAM_WRONG(2005,"评论类型出错"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，要不换个试试"),
    CONTENT_IS_EMPTY(2007,"回复内容不能为空，请重试"),
    READ_NOTIFICATION_FAIL(2008,"查看通知失败，不能查看他人通知"),
    NOTIFICATION_NOT_FOUND(2009,"你查找的通知找不到"),
    ;


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
