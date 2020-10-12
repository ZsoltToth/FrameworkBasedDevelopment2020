package hu.uni.eszterhazy.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class User {

    private final String userId;
    private final String name;
    private final Collection<Permissions> permissions;
}
