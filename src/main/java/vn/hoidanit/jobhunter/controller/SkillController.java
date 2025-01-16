package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkraft.springfilter.boot.Filter;

import vn.hoidanit.jobhunter.domain.Skill;
import vn.hoidanit.jobhunter.domain.response.ResultPaginationDTO;
import vn.hoidanit.jobhunter.service.SkillService;
import vn.hoidanit.jobhunter.util.annotation.ApiMessage;
import vn.hoidanit.jobhunter.util.error.IdInvalidException;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public ResponseEntity<ResultPaginationDTO> getAllSkill(@Filter Specification spec, Pageable pageable) {
        ResultPaginationDTO listSkill = this.skillService.fetchAllSkill(spec, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listSkill);
    }

    @PostMapping("/skills")
    @ApiMessage("Add Skill")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill reqSkill) {
        Skill skill = this.skillService.handleAddSkill(reqSkill);

        return ResponseEntity.status(HttpStatus.CREATED).body(skill);
    }

    @PutMapping("/skills")
    @ApiMessage("Update Skill")
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill reqSkill) {
        Skill skill = this.skillService.handleUpdateSkill(reqSkill);

        return ResponseEntity.status(HttpStatus.OK).body(skill);
    }

    @DeleteMapping("/skills/{id}")
    @ApiMessage("Delete Skill")
    public ResponseEntity<Void> deleteSkill(@PathVariable("id") long id) throws IdInvalidException {

        if (this.skillService.fetchSkillById(id) == null) {
            throw new IdInvalidException("Skill với id " + id + " không tồn tại!");
        }

        this.skillService.handleDeleteSkill(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
