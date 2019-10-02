package com.example.demo;

import com.example.demo.FlightInfo;
import com.example.demo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/")
    public String form(Model model){
        model.addAttribute("flightInfos", flightRepository.findAll());
                return "list";
    }

    @GetMapping("/add")
    public String addFlight(Model model){
        model.addAttribute("flightInfo", new FlightInfo());
        return "flightForm";
    }

    @PostMapping("/processearch")
    public String searchResult(Model model, @RequestParam(name="search")String search){
        model.addAttribute("flights", flightRepository.findByAirlineContainingIgnoreCase(search));

        return "searchlist";
    }



    @PostMapping("/processFlight")
    public String processFlight(@ModelAttribute FlightInfo flightInfo,
                                @RequestParam(name = "date") String date){
        String pattern = "yyyy-MM-dd";
        System.out.println("before: " +date);

        try {
            String formattedDate = date.substring(1);
            System.out.println(formattedDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date realDate = simpleDateFormat.parse(formattedDate);
            flightInfo.setDate(realDate);
            System.out.println("after ; " + realDate);
        }
        catch (java.text.ParseException e){
            e.printStackTrace();
        }

        flightRepository.save(flightInfo);

        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showFligtInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("flightInfo", flightRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateFlight(@PathVariable("id") long id, Model model){
        model.addAttribute("flightInfo", flightRepository.findById(id).get());
        return "flightForm";
    }
    @RequestMapping("/delete/{id}")
    public String deleteFlight(@PathVariable ("id") long id){
        flightRepository.deleteById(id);
        return "redirect:/";
    }

}
