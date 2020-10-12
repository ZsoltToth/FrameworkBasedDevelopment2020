package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.service.AccessControlManagerService;
import hu.uni.eszterhazy.framework.service.exceptions.AccessDeniedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= {"/gate"})
@Slf4j
@RequiredArgsConstructor
public class EntrancePermissonController {

    private final AccessControlManagerService service;

    @GetMapping(value = "/{id}")
    public boolean requestAccess(@PathVariable(value = "id") int gateId, @RequestParam(value = "user") String user){
        log.info("{} requested permissont to {}", user, gateId);
        try{
            service.requestAccess(user,gateId);
        }
        catch (AccessDeniedException ex){
            return false;
        }
        return true;
    }
}
