package hu.uni.eszterhazy.framework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= {"/gate"})
@Slf4j
public class EntrancePermissonController {

    @GetMapping(value = "/{id}")
    public boolean requestAccess(@PathVariable(value = "id") int gateId, @RequestParam(value = "user") String user){
        log.info("{} requested permissont to {}", user, gateId);
        return false;
    }
}
