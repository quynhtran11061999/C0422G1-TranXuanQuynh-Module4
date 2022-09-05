package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/detail")
    public ResponseEntity<Blog> goDetail(@RequestParam int id) {
        Blog blog = this.iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> goList(@PageableDefault(size = 5) Pageable pageable,@RequestParam Optional<String> title){
        String titleVal= title.orElse("");
        Page<Blog> blogPage = this.iBlogService.findAllByTitleContaining(titleVal, pageable);
        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping(value = "/listCategory")
    public ResponseEntity<List<Blog>> goCategoryList(@RequestParam int id){
        List<Blog> blogListCategory = this.iBlogService.findByCategoryId(id);
        if (blogListCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogListCategory,HttpStatus.OK);
    }
}
