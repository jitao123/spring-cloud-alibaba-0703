package com.myself.contentcenter.service.impl;

import com.common.domain.UserCenter;
import com.myself.contentcenter.dao.ShareDao;
import com.myself.contentcenter.service.IShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareServiceImpl implements IShareService {

    private final ShareDao shareDao;
//    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;


    @Override
    public UserCenter findById(Integer id) {
//        Share share = shareDao.getOne(id);
//        if (Objects.isNull(share)) {
//           throw new RuntimeException("id 对应的 数据不存在！");
//        }
//        List<ServiceInstance> instances = this.discoveryClient.getInstances("service-usercenter");
//        String urlStr = instances.stream().map(serviceInstance -> serviceInstance.getUri() + "?userId=" + share.getUserId()).findFirst().orElseThrow(() -> new RuntimeException("数据不存在！"));
//        UserCenter userCenter = restTemplate.getForObject(urlStr, UserCenter.class, share.getUserId());
//        return userCenter;
        return null;
    }
}
