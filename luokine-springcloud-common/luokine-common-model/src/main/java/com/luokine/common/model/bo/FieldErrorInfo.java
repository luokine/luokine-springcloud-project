package com.luokine.common.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorInfo {
    /**
     * The Field name.
     */
    private String fieldName;
    /**
     * The Error message.
     */
    private String errorMessage;
}
