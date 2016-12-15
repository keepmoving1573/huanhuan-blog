/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.huan.controller;

import com.huan.bean.UserInfoBean;
import com.huan.model.UserInfo;
import com.huan.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhanhuanhuan
 */
@Controller
public class MainPageController {

    @Autowired
    private MainPageService mainPageService;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        UserInfo user = mainPageService.selectUserDetail("1");
        modelMap.put("user", user);
        return "index";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(ModelMap modelMap) {
        modelMap.put("name", "huanhuan");
        return "about";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newArticle() {
        return "new";
    }

    @RequestMapping(value = "newlist", method = RequestMethod.GET)
    public String newArticleList() {
        return "newlist";
    }

    @RequestMapping(value = "share", method = RequestMethod.GET)
    public String share() {
        return "share";
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public List<UserInfo> selectAll() {
        return mainPageService.selectAll();
    }

    @ResponseBody
    @RequestMapping(value = "testuserdetailselect", method = RequestMethod.GET)
    public UserInfo testuserdetail(String id) {
        return mainPageService.selectUserDetail(id);
    }

    @RequestMapping(value = "testuserdetailupdate", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testuserdetailupdate(@RequestBody UserInfoBean userInfoBean) {
        mainPageService.updateUser(userInfoBean);
        return "success";
    }

    @RequestMapping(value = "testuserdetailadd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testuserdetailadd(@RequestBody UserInfoBean userInfoBean) {
        mainPageService.add(userInfoBean);
        return "add success";
    }

}
