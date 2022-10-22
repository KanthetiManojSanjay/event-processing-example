package com.ep.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author kansanja on 22/10/22.
 */
@Getter
@Setter
public class AuditEvent<T> extends ApplicationEvent {
    private T data;

    public AuditEvent(T event) {
        super(event);
        this.data = event;
    }
}
