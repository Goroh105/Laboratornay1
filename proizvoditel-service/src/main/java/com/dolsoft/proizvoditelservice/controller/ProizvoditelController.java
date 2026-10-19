package com.dolsoft.proizvoditelservice.controller;

import com.dolsoft.proizvoditelservice.model.Proizvoditel;
import com.dolsoft.proizvoditelservice.service.ProizvoditelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/proizvoditels")
public class ProizvoditelController {

    @Autowired
    private ProizvoditelService proizvoditelService;

    // GET запрос
    @RequestMapping(value = "/{proizvoditelId}", method = RequestMethod.GET)
    public ResponseEntity<Proizvoditel> getProizvoditel(
            @PathVariable("proizvoditelId") String proizvoditelId) {
        
        Proizvoditel proizvoditel = proizvoditelService.getProizvoditel(proizvoditelId);

        // Добавление HATEOAS ссылок
        proizvoditel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProizvoditelController.class)
                        .getProizvoditel(proizvoditelId)).withSelfRel());

        proizvoditel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProizvoditelController.class)
                        .createProizvoditel(proizvoditel)).withRel("createProizvoditel"));

        proizvoditel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProizvoditelController.class)
                        .updateProizvoditel(proizvoditel)).withRel("updateProizvoditel"));

        proizvoditel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProizvoditelController.class)
                        .deleteProizvoditel(proizvoditelId)).withRel("deleteProizvoditel"));

        return ResponseEntity.ok(proizvoditel);
    }

    // PUT запрос
    @PutMapping
    public ResponseEntity<String> updateProizvoditel(@RequestBody Proizvoditel request) {
        return ResponseEntity.ok(proizvoditelService.updateProizvoditel(request));
    }

    // POST запрос
    @PostMapping
    public ResponseEntity<String> createProizvoditel(@RequestBody Proizvoditel request) {
        return ResponseEntity.ok(proizvoditelService.createProizvoditel(request));
    }

    // DELETE запрос
    @DeleteMapping(value = "/{proizvoditelId}")
    public ResponseEntity<String> deleteProizvoditel(@PathVariable("proizvoditelId") String proizvoditelId) {
        return ResponseEntity.ok(proizvoditelService.deleteProizvoditel(proizvoditelId));
    }
}
