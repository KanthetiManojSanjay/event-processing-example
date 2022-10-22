package com.ep.event;

import com.ep.model.LogData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kansanja on 22/10/22.
 */
@Component
public class AuditEventHandler {
    @SneakyThrows
    @Async
    @EventListener
    public void handleEvent(AuditEvent<LogData> auditEvent) {
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(auditEvent.getData()));
    }
}
