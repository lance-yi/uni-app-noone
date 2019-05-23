package com.lanceyi.noone.controller;

import com.lanceyi.noone.model.JuheWxArtListRep;
import com.lanceyi.noone.model.JuheWxArtListReq;
import com.lanceyi.noone.service.JuheWxArtListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lance YI
 * @date 2019/5/23 11:29
 */
@RestController
@RequestMapping("/juhe")
public class JuheWxArtListController {

    @Autowired
    JuheWxArtListService juheWxArtListService;


    @PostMapping("/getWxArtList")
    public JuheWxArtListRep getWxArtList(@RequestBody JuheWxArtListReq juheWxArtListReq) {
        JuheWxArtListRep wxArtList = juheWxArtListService.getWxartList(juheWxArtListReq);
        return wxArtList;
    }
}
