package com.orion.zzd.service;

import com.alibaba.fastjson.JSONObject;
import com.orion.zzd.constant.Constants;
import com.orion.zzd.requeat.Request;
import com.orion.zzd.response.Response;
import com.orion.zzd.util.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 天气服务层
 */
@Service
public class WeatherService {

    /**
     * AppKey
     */
    @Value("${appKey}")
    private String appKey;

    /**
     * AppSecret
     */
    @Value("${appSecret}")
    private String appSecret;

    /**
     * Host
     */
    @Value("${weather.host}")
    private String host;


    /**
     * 根据功能不同对应的Token不同
     */

    /**
     * 天气实况
     */
    @Value("${weather.live_weather_token}")
    private String liveWeatherToken;

    /**
     * 限行数据
     */
    @Value("${weather.lmited_data_token}")
    private String lmitedDataToken;

    /**
     * 空气质量指数
     */
    @Value("${weather.air_quality_index_token}")
    private String airQualityIndexToken;

    /**
     * AQI
     */
    @Value("${weather.aqi_token}")
    private String aqiToken;

    /**
     * 天气预警
     */
    @Value("${weather.weather_warning_token}")
    private String weatherWarningToken;

    /**
     * 天气预报15天
     */
    @Value("${weather.weather_forecast_token}")
    private String weatherForecastToken;


    /**
     * 根据功能不同设置不同的缓存失效时间
     */
    /**
     * 天气实况
     */
    @Value("${weather.expireTimeout.live_weather}")
    private String liveweatherTime;

    /**
     * 限行数据
     */
    @Value("${weather.expireTimeout.limit_data}")
    private String limitDataTime;

    /**
     * 空气质量指数
     */
    @Value("${weather.expireTimeout.air_quality_index}")
    private String airQualityIndexTime;

    /**
     * 天气预报15天
     */
    @Value("${weather.expireTimeout.weather_forecast}")
    private String weatherforecastTime;

    /**
     * 天气预警
     */
    @Value("${weather.expireTimeout.weather.warning}")
    private String weatherWarningTime;

    /**
     * AQI预报3天
     */
    @Value("${weather.expireTimeout.aqi}")
    private String aqiTime;

    /**
     *
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public String getWeather(String type, String lat, String lon) throws Exception {

        String respStr = null;
        String key = String.format("type:s%:lat:s%:lon:s%", type, lat, lon);
        if (stringRedisTemplate.hasKey(key)) {
            respStr = stringRedisTemplate.opsForValue().get(key);
        } else {
            String path = "";
            String token = "";
            String method = "";
            int timeout = 500;
            int expireTime = 15;
            switch (type) {
                case Constants.AIR_QUALITY_INDEX_TYPE:
                    path = Constants.AIR_QUALITY_INDEX_PATH;
                    token = airQualityIndexToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(airQualityIndexTime);
                    timeout = 200;
                    break;
                case Constants.ALERT_TYPE:
                    path = Constants.WEATHER_WARNING_PATH;
                    token = weatherWarningToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(weatherWarningTime);
                    timeout = 500;
                    break;
                case Constants.AQIFORECAST_TYEP:
                    path = Constants.AQI_FORECAST_PATH;
                    token = aqiToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(aqiTime);
                    timeout = 500;
                    break;
                case Constants.LIMIT_DATA_TYPE:
                    path = Constants.LIMITED_DATA_PATH;
                    token = lmitedDataToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(limitDataTime);
                    timeout = 200;
                    break;
                case Constants.LIVE_WEATHER_TYPE:
                    path = Constants.LIVE_WEATHER_PATH;
                    token = liveWeatherToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(liveweatherTime);
                    timeout = 500;
                    break;
                case Constants.WEATHER_FORECAST_TYPE:
                    path = Constants.WEATHER_FORECAST_PATH;
                    token = weatherForecastToken;
                    method = Constants.POST;
                    expireTime = Integer.parseInt(weatherforecastTime);
                    timeout = 500;
                    break;
                default:
                    //抛异常
                    break;
            }
            Map<String, String> headers = new HashMap<>();
            //（必填）根据期望的Response内容类型设置
            headers.put(Constants.HTTP_HEADER_ACCEPT, Constants.HTTP_HEADER_ACCEPT_VALUE);
            Request request = new Request(method, Constants.HTTP + host, path, appKey, appSecret, Constants.DEFAULT_TIMEOUT);
            request.setTimeout(timeout);
            request.setHeaders(headers);
            Map<String, String> bodys = new HashMap<>();
            bodys.put("lat", lat);
            bodys.put("lon", lon);
            bodys.put("token", token);
            request.setBodys(bodys);
            Response response = Client.execute(request);
            respStr = JSONObject.toJSONString(response);

            stringRedisTemplate.opsForValue().set(key, respStr, expireTime, TimeUnit.MINUTES);
        }
        return respStr;
    }


}
