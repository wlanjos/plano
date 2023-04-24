package br.com.ekan.plano.service;

import br.com.ekan.plano.entity.Beneficiario;
import br.com.ekan.plano.model.dto.BeneficiarioDTO;
import br.com.ekan.plano.model.dto.BeneficiarioDocumentoDTO;
import br.com.ekan.plano.model.dto.BeneficiarioRequest;
import br.com.ekan.plano.model.dto.BeneficiarioResponseListDTO;
import br.com.ekan.plano.repository.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioRepository repository;
    private ModelMapper modelMapper = new ModelMapper();
    public ResponseEntity save(BeneficiarioDocumentoDTO beneficiarioDTO) {

        Beneficiario beneficiario = Beneficiario.builder()
                .nome(beneficiarioDTO.getNome())
                .telefone(beneficiarioDTO.getTelefone())
                .documentos(beneficiarioDTO.getDocumentos())
                .dtNascimento(LocalDate.parse(beneficiarioDTO.getDtNascimento()))
                    .dtInclusao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .build();

       repository.save(beneficiario);

        BeneficiarioDocumentoDTO response = modelMapper.map(beneficiario, BeneficiarioDocumentoDTO.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity listAll() {

        List<BeneficiarioResponseListDTO> listDTOS = repository.findAll()
                .stream()
                .map(beneficiario -> modelMapper.map(beneficiario, BeneficiarioResponseListDTO.class))
                .collect(Collectors.toList());

        return  new ResponseEntity(listDTOS, HttpStatus.OK);
    }

    public ResponseEntity getDocumentoByBeneficiario(Long id) {

        Optional<Beneficiario> bene = repository.findById(id);
        if (bene.isEmpty()) {
            return new ResponseEntity<>("Beneficiario não encontrado", HttpStatus.UNPROCESSABLE_ENTITY);
        }else {
            BeneficiarioDocumentoDTO beneficiarioDocumentoDTO = modelMapper.map(bene.get(), BeneficiarioDocumentoDTO.class);
            return new ResponseEntity<>(beneficiarioDocumentoDTO, HttpStatus.OK);
        }

    }
    public ResponseEntity updateBeneficiario(Long id, BeneficiarioRequest request) {
        Optional<Beneficiario> bene = repository.findById(id);
        if (bene.isEmpty()) {
            return new ResponseEntity<>("Beneficiario não encontrado", HttpStatus.UNPROCESSABLE_ENTITY);
        }else {
            Beneficiario beneficiario = bene.get();

            beneficiario.setNome(request.getNome().isBlank() ? beneficiario.getNome() : request.getNome());
            beneficiario.setTelefone(request.getTelefone() == null ? beneficiario.getTelefone() : request.getTelefone());
            beneficiario.setDtNascimento(request.getDataNascimento() == null ? beneficiario.getDtNascimento(): request.getDataNascimento());
            beneficiario.setDtAtualizacao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            repository.save(beneficiario);

            BeneficiarioDTO response = modelMapper.map(beneficiario, BeneficiarioDTO.class);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    public ResponseEntity deleteBeneficiario(Long id) {
        Optional<Beneficiario> bene = repository.findById(id);
        if (bene.isEmpty()) {
            return new ResponseEntity<>("Beneficiario não encontrado", HttpStatus.UNPROCESSABLE_ENTITY);
        }else {
           repository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }

    }

}
