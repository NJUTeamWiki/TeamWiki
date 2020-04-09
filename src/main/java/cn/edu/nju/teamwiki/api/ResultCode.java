package cn.edu.nju.teamwiki.api;

/**
 * Api调用结果状态码
 *
 * @author: xuyangchen
 * @date: 2020/1/6
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    PARAM_INVALID_UPLOAD_FILE(10005, "上传的文件无效"),
    PARAM_INVALID_DOCUMENT_SOURCE(10006, "无效的文档源"),
    PARAM_NOT_IMAGE(10007, "上传的文件不是图片"),

    /* 用户错误：20001-29999*/
    USER_NOT_SIGNED_IN(20001, "用户未登录"),
    USER_SIGN_IN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_ALREADY_SIGNED_IN(20006, "用户已登录"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),
    SPECIFIED_KNOWLEDGE_EXISTS(30002, "同名知识已存在"),
    SPECIFIED_DELETE_NOT_EMPTY_KNOWLEDGE(30003, "知识不为空，请先删除知识内的文档"),

    /* 系统错误：40001-49999 */
    SYSTEM_INTERNAL_ERROR(40001, "系统繁忙，请稍后重试"),
    SYSTEM_FILE_ERROR(40002, "文件读写时发生异常"),

    /* 数据错误：50001-599999 */
    DATA_NOT_EXIST(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),
    PERMISSION_NO_MODIFY(70002, "无修改权限");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(String name) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }

    public static String getMessage(String name) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return null;
    }


}
