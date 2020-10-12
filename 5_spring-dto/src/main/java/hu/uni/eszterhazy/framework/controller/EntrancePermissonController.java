package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.controller.dto.UserAccessRequestDto;
import hu.uni.eszterhazy.framework.service.AccessControlManagerService;
import hu.uni.eszterhazy.framework.service.exceptions.AccessDeniedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value= {"/gate"})
@Slf4j
@Api("Gate Access Permission Controller")
@RequiredArgsConstructor
public class EntrancePermissonController {

    private final AccessControlManagerService service;

    @PostMapping(value = "/enter")
    @ApiOperation("Request Access to Gate with User")
    public boolean requestAccess(@RequestBody UserAccessRequestDto accessRequestDto){
        log.info("{} requested permissont to {}", accessRequestDto.getUserId(), accessRequestDto.getGateNo());
        try{
            service.requestAccess(accessRequestDto.getUserId(),accessRequestDto.getGateNo());
        }
        catch (AccessDeniedException ex){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
        return true;
    }



}
