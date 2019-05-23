package com.lanceyi.noone.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lanceyi.noone.model.JuheWxArtListRep;
import com.lanceyi.noone.model.JuheWxArtListReq;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lance YI
 * @date 2019/5/23 11:32
 */
@Service
public class JuheWxArtListService {


    private String baseUrl = "http://v.juhe.cn/weixin/query?key={key}&pno={pno}&ps={ps}&dtype={dtype}";

    public JuheWxArtListRep getWxartList(JuheWxArtListReq juheWxArtListReq){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> wxMap = new HashMap<>();
        wxMap.put("key", juheWxArtListReq.getKey());
        wxMap.put("pno", juheWxArtListReq.getPage());
        wxMap.put("ps", juheWxArtListReq.getPageSize());
        wxMap.put("dtype", "json");
        String rep = restTemplate.getForObject(baseUrl, String.class, wxMap);
        JuheWxArtListRep juheWxArtListRep = JSONObject.parseObject(rep, JuheWxArtListRep.class);
        return juheWxArtListRep;
    }
}
