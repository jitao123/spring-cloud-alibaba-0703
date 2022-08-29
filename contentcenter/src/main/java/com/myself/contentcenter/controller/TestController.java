package com.myself.contentcenter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
// 这种方式可以将引入的类不用写 @Autowired注解，但是需要将引入对象定义未final
public class TestController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("/test1")
    public List<ServiceInstance> resultAllDiscovery(@RequestParam("serviceName") String serviceName){
        List<String> services = this.discoveryClient.getServices();
        return this.discoveryClient.getInstances(serviceName);
    }
}
