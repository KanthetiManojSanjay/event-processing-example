package com.ep.event;

import com.ep.model.LogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author kansanja on 22/10/22.
 */
@Component
public class AuditEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(String message) {

        Map<String, String> dataMap = new LinkedHashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        dataMap.put("host", request.getHeader("host"));
        dataMap.put("user-agent", request.getHeader("User-Agent"));
        dataMap.put("message", message);
        applicationEventPublisher.publishEvent(new AuditEvent<LogData>(LogData.builder().data(dataMap).build()));
    }

}
