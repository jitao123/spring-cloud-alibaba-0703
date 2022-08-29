package com.myself.contentcenter.controller;

import com.common.domain.UserCenter;
import com.myself.contentcenter.service.IShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class ShareController {

    private final IShareService shareService;
    @GetMapping("/findByShareId")
    public UserCenter findByShareId(@RequestParam("/shareId") Integer shareId){
        return shareService.findById(shareId);
    }
}
