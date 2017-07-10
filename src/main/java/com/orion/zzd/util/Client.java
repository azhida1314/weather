package com.orion.zzd.util;


import com.orion.zzd.constant.Constants;
import com.orion.zzd.requeat.Request;
import com.orion.zzd.response.Response;

/**
 * Client
 */
public class Client {
    /**
     * 发送请求
     *
     * @param request request对象
     * @return Response
     * @throws Exception
     */
    public static Response execute(Request request) throws Exception {
        switch (request.getMethod()) {
            case Constants.GET:
                return HttpUtil.httpGet(request.getHost(), request.getPath(),
                        request.getTimeout(),
                        request.getHeaders(),
                        request.getQuerys(),
                        request.getSignHeaderPrefixList(),
                        request.getAppKey(), request.getAppSecret());
            case Constants.POST:
                return HttpUtil.httpPost(request.getHost(), request.getPath(),
                        request.getTimeout(),
                        request.getHeaders(),
                        request.getQuerys(),
                        request.getBodys(),
                        request.getSignHeaderPrefixList(),
                        request.getAppKey(), request.getAppSecret());

            default:
                throw new IllegalArgumentException(String.format("unsupported method:%s", request.getMethod()));
        }
    }
}
