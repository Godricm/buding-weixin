package org.buding.controller;

import org.buding.common.api.CommonResult;
import org.buding.domain.BaseUser;
import org.buding.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BaseUserController {

    @Autowired
    private BaseUserService baseUserService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<BaseUser> create(@RequestBody BaseUser user, BindingResult result){
        int i=baseUserService.insert(user);
        if(i<0){
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }
}
