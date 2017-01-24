package org.yuan.vita.photo.mode;

public class Result {
  public static final int SUCCESS = 0;
  public static final int FAILURE = 1;

  /**
   * 对象创建方法 
   */
  public static Result general(int code, String info, Object data) {
    Result result = new Result();
    result.setCode(code);
    result.setInfo(info);
    result.setData(data);
    return result;
  }

  public static Result success() {
    return success(null);
  }

  public static Result success(Object data) {
    Result result = new Result();
    result.setCode(SUCCESS);
    result.setInfo("操作成功");
    result.setData(data);
    return result;
  }

  public static Result failure() {
    return failure(FAILURE, "操作失败");
  }
  
  public static Result failure(int code, String info) {
    Result result = new Result();
    result.setCode(code);
    result.setInfo(info);
    result.setData(null);
    return result;
  }

  /**
   * 数据访问方法
   */

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  private Integer code;
  private String info;
  private Object data;
}
