package com.ethergit.slackos.Controller;


import com.ethergit.slackos.service.HerokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RPCController {

    @Autowired
    HerokuService herokuService;


    @RequestMapping(method = GET, value = "/api/releases", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    private String show() {

        return herokuService.getLast10Releases();
    }


}
