package bmsproject.com.bmsproject.features.genre.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;
import bmsproject.com.bmsproject.features.genre.services.GenreServiceImp;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class GenreViewController {
    private final GenreServiceImp genreServiceImp;
    
    public GenreViewController(GenreServiceImp genreServiceImp) {
        this.genreServiceImp = genreServiceImp;
    }

    @GetMapping("/genre")
    String genreView(GenreModel genre,ModelMap ModelMap,@ModelAttribute("check") String check)
    {
        List<GenreModel> genres = genreServiceImp.findAll();
        ModelMap.addAttribute("data",genres);
        ModelMap.addAttribute("genre",genre);
        log.info("here is ok {}",check);
        ModelMap.addAttribute("check",check);
        return "genre/genreView";

    }

    @PostMapping("/form")
    String doAddnewGenre(GenreModel genre,RedirectAttributes redirectAttributes){

        if(!(genre.getTitle().isBlank() && genre.getDescription().isBlank()))
        {    
            genreServiceImp.addNew(genre);
            redirectAttributes.addFlashAttribute("check", "C");
        }
        

        return "redirect:/genre";

    }

    @GetMapping("/genre/form")
    String returnForm(GenreModel genre,ModelMap modelMap)
    {
        modelMap.addAttribute("genre",genre);
        return "genre/form";
    }

    @GetMapping("/genre/edit/{id}")
    String returnEditData(@PathVariable Integer id,ModelMap modelMap)
    {
        GenreModel genre = genreServiceImp.findById(id);
        modelMap.addAttribute("genre",genre);
        modelMap.addAttribute("isEdit",true);
        return "/genre/form";
    }

    @PostMapping("/genre/edit/{id}")
    String doEdit(@PathVariable Integer id,GenreModel genreModel,ModelMap modelMap,RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("check","U");
        genreServiceImp.updateById(id, genreModel);
        return "redirect:/genre";
    }

    @GetMapping("/genre/delete/{id}")
    String getDeleteRequest(@PathVariable Integer id)
    {
        log.info("HEre is controller");
        genreServiceImp.deleteById(id);
        log.info("here is {}",id);
        return "redirect:/genre";
    }
}
