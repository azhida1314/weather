
package com.orion.zzd.requeat;


import java.util.List;
import java.util.Map;

/**
 * Request
 */
public class Request {

    public Request() {
    }

    public Request(String method, String host, String path, String appKey, String appSecret, int timeout) {
        this.method = method;
        this.host = host;
        this.path = path;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.timeout = timeout;
    }

    /**
     * 请求类型
     */
    private String method;

    /**
     * Host
     */
    private String host;

    /**
     * 请求Path
     */
    private String path;

    /**
     * appKey
     */
    private String appKey;

    /**
     * APP密钥
     */
    private String appSecret;

    /**
     * 超时时间,单位毫秒
     */
    private int timeout;

    /**
     *  HTTP请求头列表
     */
    private Map<String, String> headers;

    /**
     *  Querys
     */
    private Map<String, String> querys;

    /**
     * 表单参数
     */
    private Map<String, String> bodys;


    /**
     * 自定义参与签名Header前缀
     */
    private List<String> signHeaderPrefixList;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQuerys() {
        return querys;
    }

    public void setQuerys(Map<String, String> querys) {
        this.querys = querys;
    }

    public Map<String, String> getBodys() {
        return bodys;
    }

    public void setBodys(Map<String, String> bodys) {
        this.bodys = bodys;
    }

    public List<String> getSignHeaderPrefixList() {
        return signHeaderPrefixList;
    }

    public void setSignHeaderPrefixList(List<String> signHeaderPrefixList) {
        this.signHeaderPrefixList = signHeaderPrefixList;
    }
}
