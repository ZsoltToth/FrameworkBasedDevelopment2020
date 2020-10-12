package hu.uni.eszterhazy.framework.controller.dto;

import lombok.Data;

@Data
public class UserAccessRequestDto {

    private String userId;
    private int gateNo;
}
