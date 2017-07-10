package com.orion.zzd.controller;

import com.orion.zzd.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Resource
    private WeatherService weatherService;

    @RequestMapping("/{type}/{lat}/{lon}")
    public String getWeather(@PathVariable(name = "type") String type, @PathVariable(name = "lat") String lat, @PathVariable(name = "lon") String lon) throws Exception {
        return weatherService.getWeather(type, lat, lon);
    }


}
