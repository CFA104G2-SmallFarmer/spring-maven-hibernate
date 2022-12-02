package com.albert.management.controller;

import com.albert.management.dto.MemDTO;
import com.albert.management.repository.MemRepository;
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
public class MemController {
    private final Logger log = LoggerFactory.getLogger(MemController.class);
    private MemRepository memRepository;

    public MemController(MemRepository memRepository) {
        this.memRepository = memRepository;
    }

    @PostMapping("/mem")
    @ApiResponses({
        @ApiResponse(responseCode="200", description="mem added successful"),
        @ApiResponse(responseCode="400", description="cannot contain id")
    })
    public ResponseEntity<MemDTO> createMem(@RequestBody MemDTO memDTO) {
//        System.out.println(memDTO.getName());
//        System.out.println(memRepository.getByName(memDTO.getName()));
        if (memRepository.getByMemName(memDTO.getMemName()).isPresent()) {//false
            return ResponseEntity.status(400).header("err-msg", "A new mem cannot already have an id").build();
        }
        return ResponseEntity.ok().body(memRepository.save(memDTO));
    }

    @PutMapping("/mem")
    @ApiResponses({
        @ApiResponse(responseCode="200", description="mem added successful"),
        @ApiResponse(responseCode="400", description="must have an id"),
        @ApiResponse(responseCode="404", description="not existed id")
    })
    public ResponseEntity<MemDTO> updateMem(@RequestBody MemDTO memDTO) {
        if (memDTO.getMemId() == null) {
            return ResponseEntity.status(400).header("err-msg", "An update mem must have an id").build();
        } else if (!memRepository.findById(memDTO.getMemId()).isPresent()) {
            return ResponseEntity.status(404).header("err-msg", "Not existed id.").build();
        }
        return ResponseEntity.ok().body(memRepository.save(memDTO));
    }

    @DeleteMapping("/mem/{id}")
    public void deleteMemById(@PathVariable Long id) {
        memRepository.deleteById(id);
    }

    @DeleteMapping("/mem")
    public void deleteMemByEntityInBatch(@RequestBody List<MemDTO> memDTOs) {
        memRepository.deleteInBatch(memDTOs);
    }


    @GetMapping("/mems")
    public List<MemDTO> getAllMems() {
        return memRepository.findAll();
    }

    @GetMapping("/mem/{id}")
    public Optional<MemDTO> getMemById(@PathVariable Long id) {
        return memRepository.findById(id);
    }

    @GetMapping("/mem/bySortParams")
    public ResponseEntity<List<MemDTO>> findAllBySortParams(
        @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
        @RequestParam(value = "direction", defaultValue = "ASC") Direction direction
    ) {
        // 暫時不考慮排序的目標欄位是某存在，但如果搜尋的欄位名稱不存在時，則會報錯:
        // org.springframework.data.mapping.PropertyReferenceException
        return ResponseEntity.ok().body(memRepository.findAll(Sort.by(direction, sortBy)));
    }

    @GetMapping("/mem/byPageParams")
    public ResponseEntity<Page<MemDTO>> findAllByPageRequestParams(
        @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
        @RequestParam(value = "direction", defaultValue = "ASC") Direction direction,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(memRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy))));
    }

    @GetMapping("/mem/bySort")
    public ResponseEntity<List<MemDTO>> findAllBySort(Sort sort) {
        return ResponseEntity.ok().body(memRepository.findAll(sort));
    }

    @GetMapping("/mem/byPageable")
    public ResponseEntity<Page<MemDTO>> findAllByPageable(Pageable pageable) {
        return ResponseEntity.ok().body(memRepository.findAll(pageable));
    }

}
