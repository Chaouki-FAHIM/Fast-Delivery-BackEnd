package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.exception.BadMontantException;
import com.fastDelivery.exception.NonAutoriserException;
import com.fastDelivery.exception.NotFoundIDException;
import com.fastDelivery.exception.NullRequestDataException;
import com.fastDelivery.service.IColisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("colis_controller")
@RequestMapping("/api/colis")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ColisController implements IColisContoller {

    @Autowired
    @Qualifier("colis_service")
    private final IColisService colisService;


    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ColisReqDTO colisReqDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(colisService.create(colisReqDTO));
        } catch (NullRequestDataException | BadMontantException  e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colisService.getById(id));
        } catch (NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int pageNumber,@RequestParam(defaultValue = "10") int limitColis) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colisService.getAll(pageNumber,limitColis));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ColisReqDTO colisReqDTO,@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colisService.update(colisReqDTO, id));
        } catch (NullRequestDataException | BadMontantException | NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (NonAutoriserException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            colisService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("success","Bonne supression de colis"));
        } catch (NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @GetMapping("/statut-enAttente")
    public ResponseEntity<?> GetAllColisEnAttente(@RequestParam(defaultValue = "1") int pageNumber,@RequestParam(defaultValue = "10") int limitColis) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colisService.GetAllColisEnAttente(pageNumber,limitColis));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @PatchMapping("/statut/{id}")   // /api/colis/2?statut=value
    public ResponseEntity<?> changementStatut(@RequestParam String statut,@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("success", colisService.changementStatut(statut, id)));
        } catch (NotFoundIDException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

}
