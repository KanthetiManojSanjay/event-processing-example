package com.ep.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author kansanja on 22/10/22.
 */
@Getter
@Setter
@Builder
public class LogData {
    private Map<String, String> data;
}
