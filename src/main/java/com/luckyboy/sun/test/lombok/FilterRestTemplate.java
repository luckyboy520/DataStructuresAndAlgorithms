package com.luckyboy.sun.test.lombok;

import lombok.experimental.Delegate;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author xieh
 * @date 2019/12/13 15:32
 * lombok实现某个接口如果需要实现他的所有方法，如果使用Delegate注解则不需要
 */
public abstract class FilterRestTemplate implements RestOperations {
    @Delegate
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
