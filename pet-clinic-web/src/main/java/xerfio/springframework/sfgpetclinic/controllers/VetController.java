package xerfio.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xerfio.springframework.sfgpetclinic.model.Vet;
import xerfio.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Controller
public class VetController {

    private final VetService  vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets","/vets/index","/index","/index.html","/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }


    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){
        return vetService.findAll();
    }

}
