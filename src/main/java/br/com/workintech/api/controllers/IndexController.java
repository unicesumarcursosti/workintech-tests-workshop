package br.com.workintech.api.controllers;

import br.com.workintech.api.DTO.AddOperationDTO;
import br.com.workintech.api.DTO.AddOperationResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class IndexController {

    @PostMapping("/add")
    public AddOperationResult add(@RequestBody AddOperationDTO addOperationDTO) {

        return new AddOperationResult(10);
    }
}
