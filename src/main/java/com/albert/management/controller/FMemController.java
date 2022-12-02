package com.albert.management.controller;

import com.albert.management.dto.FMemDTO;
import com.albert.management.repository.FMemRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class FMemController {
    private final Logger log = LoggerFactory.getLogger(FMemController.class);
    private FMemRepository fMemRepository;

    public FMemController(FMemRepository fMemRepository) {
        this.fMemRepository = fMemRepository;
    }

    @PostMapping("/fmem")
    @ApiResponses({
        @ApiResponse(responseCode="200", description="mem added successful"),
        @ApiResponse(responseCode="400", description="cannot contain id")
    })
    public ResponseEntity<FMemDTO> createMem(@RequestBody FMemDTO fMemDTO) {
        if (fMemRepository.getByfMemFname(fMemDTO.getF_mem_fname()).isPresent()) {//false
            return ResponseEntity.status(400).header("err-msg", "A new mem cannot already have an id").build();
        }
        return ResponseEntity.ok().body(fMemRepository.save(fMemDTO));
    }

    @PutMapping("/fmem")
    @ApiResponses({
        @ApiResponse(responseCode="200", description="mem added successful"),
        @ApiResponse(responseCode="400", description="must have an id"),
        @ApiResponse(responseCode="404", description="not existed id")
    })
    public ResponseEntity<FMemDTO> updateMem(@RequestBody FMemDTO fMemDTO) {
        if (fMemDTO.getF_mem_id() == null) {
            return ResponseEntity.status(400).header("err-msg", "An update mem must have an id").build();
        } else if (!fMemRepository.findById(fMemDTO.getF_mem_id()).isPresent()) {
            return ResponseEntity.status(404).header("err-msg", "Not existed id.").build();
        }
        return ResponseEntity.ok().body(fMemRepository.save(fMemDTO));
    }

    @DeleteMapping("/fmem/{id}")
    public void deleteMemById(@PathVariable Long id) {
        fMemRepository.deleteById(id);
    }

    @DeleteMapping("/fmem")
    public void deleteMemByEntityInBatch(@RequestBody List<FMemDTO> fMemDTOs) {
        fMemRepository.deleteInBatch(fMemDTOs);
    }


    @GetMapping("/fmems")
    public List<FMemDTO> getAllMems() {
        return fMemRepository.findAll();
    }

    @GetMapping("/fmem/{id}")
    public Optional<FMemDTO> getMemById(@PathVariable Long id) {
        return fMemRepository.findById(id);
    }

    @GetMapping("/fmem/bySortParams")
    public ResponseEntity<List<FMemDTO>> findAllBySortParams(
        @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
        @RequestParam(value = "direction", defaultValue = "ASC") Direction direction
    ) {
        // 暫時不考慮排序的目標欄位是某存在，但如果搜尋的欄位名稱不存在時，則會報錯:
        // org.springframework.data.mapping.PropertyReferenceException
        return ResponseEntity.ok().body(fMemRepository.findAll(Sort.by(direction, sortBy)));
    }

    @GetMapping("/fmem/byPageParams")
    public ResponseEntity<Page<FMemDTO>> findAllByPageRequestParams(
        @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
        @RequestParam(value = "direction", defaultValue = "ASC") Direction direction,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(fMemRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy))));
    }

    @GetMapping("/fmem/bySort")
    public ResponseEntity<List<FMemDTO>> findAllBySort(Sort sort) {
        return ResponseEntity.ok().body(fMemRepository.findAll(sort));
    }

    @GetMapping("/fmem/byPageable")
    public ResponseEntity<Page<FMemDTO>> findAllByPageable(Pageable pageable) {
        return ResponseEntity.ok().body(fMemRepository.findAll(pageable));
    }

}
