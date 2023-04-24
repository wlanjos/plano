package br.com.ekan.plano.controller;

import br.com.ekan.plano.model.dto.BeneficiarioDocumentoDTO;
import br.com.ekan.plano.model.dto.BeneficiarioRequest;
import br.com.ekan.plano.service.BeneficiarioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/beneficiario")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService service;

    @PostMapping
    @ApiOperation(value = "Cadastrar um beneficiário junto com seus documentos")
    public ResponseEntity create(@RequestBody BeneficiarioDocumentoDTO beneficiarioDocumentoDTO) {

        return service.save(beneficiarioDocumentoDTO);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os beneficiários cadastrados")
    public ResponseEntity listAllBeneficiarios() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar todos os documentos de um beneficiário a partir de seu id")
    public ResponseEntity getDocumentoByBeneficiario(@PathVariable Long id){

        return service.getDocumentoByBeneficiario(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar os dados cadastrais")
    public ResponseEntity updateBeneficiario(@PathVariable Long id, @RequestBody BeneficiarioRequest request){
        return service.updateBeneficiario(id,request);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remover um beneficiário")
    public ResponseEntity deleteBeneficiario(@PathVariable Long id){
        return service.deleteBeneficiario(id);
    }

}
