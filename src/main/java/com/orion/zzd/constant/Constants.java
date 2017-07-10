package com.orion.zzd.constant;

/**
 * 通用常量
 */
public class Constants {

    public static final String AQIFORECAST_TYEP = "1";

    public static final String ALERT_TYPE = "2";

    public static final String WEATHER_FORECAST_TYPE = "3";

    public static final String LIVE_WEATHER_TYPE = "4";

    public static final String LIMIT_DATA_TYPE = "5";

    public static final String AIR_QUALITY_INDEX_TYPE = "6";

    /**
     * 请求路径
     */
    public static final String AQI_FORECAST_PATH = "/whapi/json/aliweather/aqiforecast3days";

    /**
     * 请求路径
     */
    public static final String WEATHER_WARNING_PATH = "/whapi/json/aliweather/alert";

    /**
     * 请求路径
     */
    public static final String WEATHER_FORECAST_PATH = "/whapi/json/aliweather/briefforecast15days";

    /**
     * 请求路径
     */
    public static final String LIVE_WEATHER_PATH = "/whapi/json/aliweather/condition";

    /**
     * 请求路径
     */
    public static final String LIMITED_DATA_PATH = "/whapi/json/aliweather/limit";

    /**
     * 请求路径
     */
    public static final String AIR_QUALITY_INDEX_PATH = "/whapi/json/aliweather/aqi";

    /**
     * 签名算法HmacSha256
     */

    public static final String HMAC_SHA256 = "HmacSHA256";

    /**
     * 编码UTF-8
     */
    public static final String ENCODING = "UTF-8";

    /**
     * 换行符
     */
    public static final String LF = "\n";

    /**
     * 串联符
     */
    public static final String SPE1 = ",";

    /**
     * v示意符
     */
    public static final String SPE2 = ":";

    /**
     * 连接符
     */
    public static final String SPE3 = "&";

    /**
     * 赋值符
     */
    public static final String SPE4 = "=";

    /**
     * 问号符
     */
    public static final String SPE5 = "?";

    /**
     * 默认请求超时时间,单位毫秒
     */
    public static final int DEFAULT_TIMEOUT = 500;

    /**
     * 参与签名的系统Header前缀,只有指定前缀的Header才会参与到签名中
     */
    public static final String CA_HEADER_TO_SIGN_PREFIX_SYSTEM = "X-Ca-";

    /**
     * 表单类型Content-Type
     */
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded; charset=UTF-8";

    /**
     * GET
     */
    public static final String GET = "GET";

    /**
     * POST
     */
    public static final String POST = "POST";

    /**
     * HTTP
     */
    public static final String HTTP = "http://";

    /**
     * HTTPS
     */
    public static final String HTTPS = "https://";

    /**
     * 请求Header Accept
     */
    public static final String HTTP_HEADER_ACCEPT = "Accept";

    /**
     * 请求Header Accept
     */
    public static final String HTTP_HEADER_ACCEPT_VALUE = "application/json";

    /**
     * 请求Body内容MD5 Header
     */
    public static final String HTTP_HEADER_CONTENT_MD5 = "Content-MD5";

    /**
     * 请求Header Content-Type
     */
    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";

    /**
     * 请求Header Date
     */
    public static final String HTTP_HEADER_DATE = "Date";

    /**
     * 签名Header
     */
    public static final String X_CA_SIGNATURE = "X-Ca-Signature";

    /**
     * 所有参与签名的Header
     */
    public static final String X_CA_SIGNATURE_HEADERS = "X-Ca-Signature-Headers";

    /**
     * 请求时间戳
     */
    public static final String X_CA_TIMESTAMP = "X-Ca-Timestamp";

    /**
     * 请求放重放Nonce,15分钟内保持唯一,建议使用UUID
     */
    public static final String X_CA_NONCE = "X-Ca-Nonce";

    /**
     * APP KEY
     */
    public static final String X_CA_KEY = "X-Ca-Key";

}
