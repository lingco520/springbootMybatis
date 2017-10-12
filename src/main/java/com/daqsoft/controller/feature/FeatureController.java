/**
 * @Copyright: <a htef="http://www.daqsoft.com
 * <p>
 * ">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
package com.daqsoft.controller.feature;


import com.daqsoft.commons.responseEntity.ResponseBuilder;
import com.daqsoft.service.feature.FeatureService;
import com.daqsoft.common.annotation.SysLog;
import com.daqsoft.common.validator.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Title: ParkingController
 * @Author: tanggm
 * @Date: 2017/10/09 11:42
 * @Description: TODO
 * @Comment：
 * @see
 * @Version:
 * @since JDK 1.8
 * @Warning:
 */
@RestController
@RequestMapping("/menu")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @SysLog("菜单信息")
    @ApiOperation(value = "菜单信息", notes = "菜单信息")
    /* 多个参数的形式
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "Integer")
    })*/
    @ApiImplicitParam(name = "pid", value = "pid", required = true, paramType = "String")
    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    public Object getMenu(String pid) throws JsonProcessingException {
        Assert.paramIsNumber(pid, "pid不能为空");
        List<Map> menuList = featureService.getMenu(Integer.valueOf(pid));
        return ResponseBuilder.custom().success("success",0).data(menuList).build();
    }
}
