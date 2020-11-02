package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.controller.dto.PizzaDto;
import hu.uni.eszterhazy.framework.model.Pizza;
import hu.uni.eszterhazy.framework.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pizza")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService service;

    @GetMapping(value = {"/all", "/"})
    public Collection<PizzaDto> queryPizzas(){
        return service.getPizzas().stream()
                .map( model ->
                        PizzaDto.builder()
                                .name(model.getName())
                                .price(model.getPrice())
                                .build())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/record")
    public void record(@RequestBody PizzaDto dto){
        service.record(new Pizza(dto.getName(), dto.getPrice(), false));
    }
}
