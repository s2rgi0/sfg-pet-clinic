package xerfio.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xerfio.springframework.sfgpetclinic.model.Owner;
import xerfio.springframework.sfgpetclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping("/find")
    public String findOwners(Map<String, Object> model){
        model.put("owner", new Owner());
        //model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping
    public String processFindForm( Owner owner, BindingResult result, Model model){

        //System.out.println("RequestParam :::::: "+lastName);
        System.out.println("owner.toString "+owner.toString());
        System.out.println("owner.getLastName ::::: "+owner.getLastName()+"       ::::::::::::");
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }
        System.out.println("last Name ::::::: "+owner.getLastName()+":::::: MOdel :::::::"+model.toString());
        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
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

    @GetMapping("/new")
    public String initCreationForm( Map<String, Object> model ){
        Owner owner = new Owner();
        model.put("owner", owner);
        //model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }


    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){

        System.out.println("onwner NEW :::: "+owner.toString());
        if(result.hasErrors()){
            return  VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId){

        if(result.hasErrors()){
            return  VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
        owner.setId(ownerId);
        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/"+savedOwner.getId();
        }
        }







}
