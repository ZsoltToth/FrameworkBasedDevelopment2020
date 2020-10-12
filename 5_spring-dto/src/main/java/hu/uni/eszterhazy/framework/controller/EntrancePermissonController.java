package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.controller.dto.UserAccessRequestDto;
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

    @PostMapping(value = "/enter")
    public boolean requestAccess(@RequestBody UserAccessRequestDto dto){
        log.info("{} requested permissont to {}", dto.getUserId(), dto.getGateNo());
        try{
            service.requestAccess(dto.getUserId(),dto.getGateNo());
        }
        catch (AccessDeniedException ex){
            return false;
        }
        return true;
    }



}
