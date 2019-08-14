package entity;

import lombok.Data;

@Data
public class Result {
	/** 是否成功 */
	private boolean flag;
	/** 状态码 */
	private Integer code;
	/** 消息 */
	private String message;
	/** 数据 */
	private Object data;

	public Result(boolean flag, Integer code, String message, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(boolean flag, Integer code, String message) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
	}

}
