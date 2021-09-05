package xerfio.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xerfio.springframework.sfgpetclinic.model.Owner;
import xerfio.springframework.sfgpetclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private Owner owner;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setAllowedFields("id");
    }


    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @PostMapping
    @RequestMapping("")
    public String processFindForm(@ModelAttribute("owner") Owner owner, @RequestParam("lastName") String lastName, BindingResult result, Model model){

        System.out.println("RequestParam :::::: "+lastName);
        System.out.println("owner.toString "+owner.toString());
        System.out.println("owner.getLastName ::::: "+owner.getLastName()+"       ::::::::::::");
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }
        System.out.println("last Name ::::::: "+owner.getLastName()+":::::: MOdel :::::::"+model.toString());
        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+lastName+"%");
        System.out.println("results size "+results.size());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
}
