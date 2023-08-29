package com.java.aula03.controllers;

import com.java.aula03.dto.MilitarDTO;
import com.java.aula03.enums.MensagemEnum;
import com.java.aula03.services.MilitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/militar")
public class MilitarController {

    @Autowired
    private MilitarService militarService;

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        try {
            List<MilitarDTO> militares = militarService.listarTodos();
            return ResponseEntity.ok(militares);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/buscar")
    public ResponseEntity buscar(@RequestParam("id") Long id) {
        try {
            MilitarDTO militarDTO = militarService.buscarPorId(id);
            return ResponseEntity.ok(militarDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        try {
            militarService.excluir(id);
            return ResponseEntity.ok(MensagemEnum.EXCLUSAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody MilitarDTO militarDTO) {
        try {
            militarService.salvar(militarDTO);
            return ResponseEntity.ok(MensagemEnum.INCLUSAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/atualizar")
    public ResponseEntity atualizar(@RequestBody MilitarDTO militarDTO) {
        try {
            militarService.salvar(militarDTO);
            return ResponseEntity.ok(MensagemEnum.ALTERACAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}