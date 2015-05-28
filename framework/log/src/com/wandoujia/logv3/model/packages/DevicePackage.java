// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ./log_extra_package.proto
package com.wandoujia.logv3.model.packages;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;

/**
 * 设备信息
 */
public final class DevicePackage extends Message {

  public static final String DEFAULT_OS = "";
  public static final String DEFAULT_OS_VERSION = "";
  public static final Integer DEFAULT_SDK_INT = 0;
  public static final String DEFAULT_MODEL = "";
  public static final String DEFAULT_BRAND = "";
  public static final Boolean DEFAULT_IS_ROOT = false;
  public static final String DEFAULT_ROM_VERSION = "";
  public static final String DEFAULT_ROM_NAME = "";
  public static final String DEFAULT_LAUNCHER_NAME = "";
  public static final String DEFAULT_CPU = "";
  public static final String DEFAULT_SCREEN = "";
  public static final String DEFAULT_MAC = "";
  public static final String DEFAULT_IMEI = "";
  public static final Integer DEFAULT_OS_BIT = 0;
  public static final Long DEFAULT_MEMORY_SIZE = 0L;
  public static final Long DEFAULT_SDCARD1_SIZE = 0L;
  public static final Long DEFAULT_SDCARD2_SIZE = 0L;

  /**
   * 系统平台 (p4默认android)
   */
  @ProtoField(tag = 1, type = STRING)
  public final String os;

  /**
   * 平台版本
   */
  @ProtoField(tag = 2, type = STRING)
  public final String os_version;

  /**
   * 平台sdk版本
   */
  @ProtoField(tag = 3, type = INT32)
  public final Integer sdk_int;

  /**
   * 机型
   */
  @ProtoField(tag = 4, type = STRING)
  public final String model;

  /**
   * 品牌
   */
  @ProtoField(tag = 5, type = STRING)
  public final String brand;

  /**
   * 是否root
   */
  @ProtoField(tag = 6, type = BOOL)
  public final Boolean is_root;

  /**
   * rom的版本
   */
  @ProtoField(tag = 7, type = STRING)
  public final String rom_version;

  /**
   * rom的名称
   */
  @ProtoField(tag = 8, type = STRING)
  public final String rom_name;

  /**
   * launcher name
   */
  @ProtoField(tag = 9, type = STRING)
  public final String launcher_name;

  /**
   * cpu型号
   */
  @ProtoField(tag = 10, type = STRING)
  public final String cpu;

  /**
   * 设备屏幕分辩率
   */
  @ProtoField(tag = 11, type = STRING)
  public final String screen;

  /**
   * mac 地址
   */
  @ProtoField(tag = 12, type = STRING)
  public final String mac;

  /**
   * imei 号
   */
  @ProtoField(tag = 13, type = STRING)
  public final String imei;

  /**
   * 位数
   */
  @ProtoField(tag = 14, type = INT32)
  public final Integer os_bit;

  /**
   * 单位为 byte,内存的大小
   */
  @ProtoField(tag = 15, type = INT64)
  public final Long memory_size;

  /**
   * 单位为 byte,SD 卡槽一的大小
   */
  @ProtoField(tag = 16, type = INT64)
  public final Long sdcard1_size;

  /**
   * 单位为 byte,SD 卡槽二的大小
   */
  @ProtoField(tag = 17, type = INT64)
  public final Long sdcard2_size;

  private DevicePackage(Builder builder) {
    super(builder);
    this.os = builder.os;
    this.os_version = builder.os_version;
    this.sdk_int = builder.sdk_int;
    this.model = builder.model;
    this.brand = builder.brand;
    this.is_root = builder.is_root;
    this.rom_version = builder.rom_version;
    this.rom_name = builder.rom_name;
    this.launcher_name = builder.launcher_name;
    this.cpu = builder.cpu;
    this.screen = builder.screen;
    this.mac = builder.mac;
    this.imei = builder.imei;
    this.os_bit = builder.os_bit;
    this.memory_size = builder.memory_size;
    this.sdcard1_size = builder.sdcard1_size;
    this.sdcard2_size = builder.sdcard2_size;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof DevicePackage)) return false;
    DevicePackage o = (DevicePackage) other;
    return equals(os, o.os)
        && equals(os_version, o.os_version)
        && equals(sdk_int, o.sdk_int)
        && equals(model, o.model)
        && equals(brand, o.brand)
        && equals(is_root, o.is_root)
        && equals(rom_version, o.rom_version)
        && equals(rom_name, o.rom_name)
        && equals(launcher_name, o.launcher_name)
        && equals(cpu, o.cpu)
        && equals(screen, o.screen)
        && equals(mac, o.mac)
        && equals(imei, o.imei)
        && equals(os_bit, o.os_bit)
        && equals(memory_size, o.memory_size)
        && equals(sdcard1_size, o.sdcard1_size)
        && equals(sdcard2_size, o.sdcard2_size);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = os != null ? os.hashCode() : 0;
      result = result * 37 + (os_version != null ? os_version.hashCode() : 0);
      result = result * 37 + (sdk_int != null ? sdk_int.hashCode() : 0);
      result = result * 37 + (model != null ? model.hashCode() : 0);
      result = result * 37 + (brand != null ? brand.hashCode() : 0);
      result = result * 37 + (is_root != null ? is_root.hashCode() : 0);
      result = result * 37 + (rom_version != null ? rom_version.hashCode() : 0);
      result = result * 37 + (rom_name != null ? rom_name.hashCode() : 0);
      result = result * 37 + (launcher_name != null ? launcher_name.hashCode() : 0);
      result = result * 37 + (cpu != null ? cpu.hashCode() : 0);
      result = result * 37 + (screen != null ? screen.hashCode() : 0);
      result = result * 37 + (mac != null ? mac.hashCode() : 0);
      result = result * 37 + (imei != null ? imei.hashCode() : 0);
      result = result * 37 + (os_bit != null ? os_bit.hashCode() : 0);
      result = result * 37 + (memory_size != null ? memory_size.hashCode() : 0);
      result = result * 37 + (sdcard1_size != null ? sdcard1_size.hashCode() : 0);
      result = result * 37 + (sdcard2_size != null ? sdcard2_size.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<DevicePackage> {

    public String os;
    public String os_version;
    public Integer sdk_int;
    public String model;
    public String brand;
    public Boolean is_root;
    public String rom_version;
    public String rom_name;
    public String launcher_name;
    public String cpu;
    public String screen;
    public String mac;
    public String imei;
    public Integer os_bit;
    public Long memory_size;
    public Long sdcard1_size;
    public Long sdcard2_size;

    public Builder() {
    }

    public Builder(DevicePackage message) {
      super(message);
      if (message == null) return;
      this.os = message.os;
      this.os_version = message.os_version;
      this.sdk_int = message.sdk_int;
      this.model = message.model;
      this.brand = message.brand;
      this.is_root = message.is_root;
      this.rom_version = message.rom_version;
      this.rom_name = message.rom_name;
      this.launcher_name = message.launcher_name;
      this.cpu = message.cpu;
      this.screen = message.screen;
      this.mac = message.mac;
      this.imei = message.imei;
      this.os_bit = message.os_bit;
      this.memory_size = message.memory_size;
      this.sdcard1_size = message.sdcard1_size;
      this.sdcard2_size = message.sdcard2_size;
    }

    /**
     * 系统平台 (p4默认android)
     */
    public Builder os(String os) {
      this.os = os;
      return this;
    }

    /**
     * 平台版本
     */
    public Builder os_version(String os_version) {
      this.os_version = os_version;
      return this;
    }

    /**
     * 平台sdk版本
     */
    public Builder sdk_int(Integer sdk_int) {
      this.sdk_int = sdk_int;
      return this;
    }

    /**
     * 机型
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * 品牌
     */
    public Builder brand(String brand) {
      this.brand = brand;
      return this;
    }

    /**
     * 是否root
     */
    public Builder is_root(Boolean is_root) {
      this.is_root = is_root;
      return this;
    }

    /**
     * rom的版本
     */
    public Builder rom_version(String rom_version) {
      this.rom_version = rom_version;
      return this;
    }

    /**
     * rom的名称
     */
    public Builder rom_name(String rom_name) {
      this.rom_name = rom_name;
      return this;
    }

    /**
     * launcher name
     */
    public Builder launcher_name(String launcher_name) {
      this.launcher_name = launcher_name;
      return this;
    }

    /**
     * cpu型号
     */
    public Builder cpu(String cpu) {
      this.cpu = cpu;
      return this;
    }

    /**
     * 设备屏幕分辩率
     */
    public Builder screen(String screen) {
      this.screen = screen;
      return this;
    }

    /**
     * mac 地址
     */
    public Builder mac(String mac) {
      this.mac = mac;
      return this;
    }

    /**
     * imei 号
     */
    public Builder imei(String imei) {
      this.imei = imei;
      return this;
    }

    /**
     * 位数
     */
    public Builder os_bit(Integer os_bit) {
      this.os_bit = os_bit;
      return this;
    }

    /**
     * 单位为 byte,内存的大小
     */
    public Builder memory_size(Long memory_size) {
      this.memory_size = memory_size;
      return this;
    }

    /**
     * 单位为 byte,SD 卡槽一的大小
     */
    public Builder sdcard1_size(Long sdcard1_size) {
      this.sdcard1_size = sdcard1_size;
      return this;
    }

    /**
     * 单位为 byte,SD 卡槽二的大小
     */
    public Builder sdcard2_size(Long sdcard2_size) {
      this.sdcard2_size = sdcard2_size;
      return this;
    }

    @Override
    public DevicePackage build() {
      return new DevicePackage(this);
    }
  }
}