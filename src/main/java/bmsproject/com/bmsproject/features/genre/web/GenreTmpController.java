package bmsproject.com.bmsproject.features.genre.web;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bmsproject.com.bmsproject.features.genre.services.GenreServiceImp;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class GenreTmpController {
    private final GenreServiceImp genreServiceImp;
    
    public GenreTmpController(GenreServiceImp genreServiceImp) {
        this.genreServiceImp = genreServiceImp;
    }

    @GetMapping("/tmp/genre/table")
    String getTemplateTableString(ModelMap modelMap)
    {
        // log.info("here is id {}",id);
        modelMap.addAttribute("data",genreServiceImp.findAll());
        return "/genre/table";
    }

    
}
