package com.mobisoftinfotech.opensearchdemo.dto;

import java.util.Map;
import lombok.Data;

@Data
public class StudentSearchRequest {
    private Map<String, String> searchFields;
    private int offset = 0;
    private int limit = 10;
} 