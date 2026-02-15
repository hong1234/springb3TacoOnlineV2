package com.hong.flyway.config;

import java.util.List;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ErrorResponseDTO {
    private List<String> errors;
}
