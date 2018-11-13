package jp.co.pnop.moris.azure.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.pnop.moris.azure.api.demo.service.VirtualMachineService;

@Controller
@EnableAutoConfiguration
public class VirtualMachineController {

    @Autowired
    private VirtualMachineService _service;

    @GetMapping("/")
    public ModelAndView listVms(Model model) {
        var mv = new ModelAndView("index");
        var models = _service.listVirtualMachies();
        mv.addObject("vms", models);
        return mv;
    }
    
    @RequestMapping(value = "/start", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String startVm(@RequestBody OperationRequest request) {
        _service.start(request.getId());
        return "redirect:/";
    }
    
    @RequestMapping(value = "/deallocate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deallocateVm(@RequestBody OperationRequest request) {
        _service.deallocate(request.getId());
        return "redirect:/";
    }
}
