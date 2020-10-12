package hu.uni.eszterhazy.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Gate {

    private final int gateNo;
    private final Permissions requiredPermission;
}
