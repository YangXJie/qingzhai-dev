package entity;

import lombok.Data;

import java.util.List;

/**
 *  分页查询后返回类
 * @param <T>
 */
@Data
public class PageResult<T> {

    /** 执行是否成功 */
    private Boolean flag;
    /** 状态码 */
    private int code;
    /** 执行消息 */
    private String message;
    /** 总记录数 */
    private Long total;
    /** 一页的数据 */
    private List<T> rows;

    public PageResult(Boolean flag, int code, String message, Long total, List<T> rows) {
        this.code = code;
        this.flag = flag;
        this.message = message;
        this.total = total;
        this.rows = rows;
    }

}
