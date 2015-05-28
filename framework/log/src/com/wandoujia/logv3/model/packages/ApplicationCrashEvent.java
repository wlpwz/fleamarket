// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ./log_event_package.proto
package com.wandoujia.logv3.model.packages;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.STRING;

/**
 * 应用崩溃
 */
public final class ApplicationCrashEvent extends Message {

  public static final Type DEFAULT_TYPE = Type.APP_CRASH;
  public static final String DEFAULT_DETAIL = "";
  public static final Boolean DEFAULT_IS_LAUNCH = false;
  public static final String DEFAULT_ACTIVITY = "";

  /**
   * 崩溃类型
   */
  @ProtoField(tag = 1, type = ENUM)
  public final Type type;

  /**
   * 崩溃具体信息
   */
  @ProtoField(tag = 2, type = STRING)
  public final String detail;

  /**
   * 当前页面信息
   */
  @ProtoField(tag = 3)
  public final ViewLogPackage view;

  /**
   * 是否为启动
   */
  @ProtoField(tag = 4, type = BOOL)
  public final Boolean is_launch;

  /**
   * 当前Activity
   */
  @ProtoField(tag = 5, type = STRING)
  public final String activity;

  private ApplicationCrashEvent(Builder builder) {
    super(builder);
    this.type = builder.type;
    this.detail = builder.detail;
    this.view = builder.view;
    this.is_launch = builder.is_launch;
    this.activity = builder.activity;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof ApplicationCrashEvent)) return false;
    ApplicationCrashEvent o = (ApplicationCrashEvent) other;
    return equals(type, o.type)
        && equals(detail, o.detail)
        && equals(view, o.view)
        && equals(is_launch, o.is_launch)
        && equals(activity, o.activity);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = type != null ? type.hashCode() : 0;
      result = result * 37 + (detail != null ? detail.hashCode() : 0);
      result = result * 37 + (view != null ? view.hashCode() : 0);
      result = result * 37 + (is_launch != null ? is_launch.hashCode() : 0);
      result = result * 37 + (activity != null ? activity.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<ApplicationCrashEvent> {

    public Type type;
    public String detail;
    public ViewLogPackage view;
    public Boolean is_launch;
    public String activity;

    public Builder() {
    }

    public Builder(ApplicationCrashEvent message) {
      super(message);
      if (message == null) return;
      this.type = message.type;
      this.detail = message.detail;
      this.view = message.view;
      this.is_launch = message.is_launch;
      this.activity = message.activity;
    }

    /**
     * 崩溃类型
     */
    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    /**
     * 崩溃具体信息
     */
    public Builder detail(String detail) {
      this.detail = detail;
      return this;
    }

    /**
     * 当前页面信息
     */
    public Builder view(ViewLogPackage view) {
      this.view = view;
      return this;
    }

    /**
     * 是否为启动
     */
    public Builder is_launch(Boolean is_launch) {
      this.is_launch = is_launch;
      return this;
    }

    /**
     * 当前Activity
     */
    public Builder activity(String activity) {
      this.activity = activity;
      return this;
    }

    @Override
    public ApplicationCrashEvent build() {
      return new ApplicationCrashEvent(this);
    }
  }

  public enum Type
      implements ProtoEnum {
    APP_CRASH(0),
    /**
     * 应用崩溃
     */
    LOG_CRASH(1),
    /**
     * 日志模块崩溃（已catch）
     */
    PLUGIN_CRASH(2);

    private final int value;

    private Type(int value) {
      this.value = value;
    }

    @Override
    public int getValue() {
      return value;
    }
  }
}