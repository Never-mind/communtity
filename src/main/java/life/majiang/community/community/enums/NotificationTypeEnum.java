package life.majiang.community.community.enums;

public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"评论了问题"),
    REPLY_COMMAND(2,"回复了评论");
    private int type;
    private String message;

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    NotificationTypeEnum(int type, String message) {
        this.type = type;
        this.message = message;
    }
    public static String nameOfType(int type){
        for (NotificationTypeEnum typeEnum : NotificationTypeEnum.values()) {
            if(typeEnum.getType()==type){
                return typeEnum.getMessage();
            }
        }
        return "";
    }
}
