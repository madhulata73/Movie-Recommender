package com.example.springbootmovie.controller;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.service.ActorService;
import com.example.springbootmovie.service.impl.MovieServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final MovieServiceImpl movieService;
    private final ActorService actorService;

    @Autowired
    public ActorController(MovieServiceImpl movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/showActors")
    public String showActorLists(Model model){
    	List<Actor> actorList= actorService.getActors();
    	List<Actor> directorList=new ArrayList<Actor>();
    	Iterator<Actor> actorItr = actorList.iterator();
    	while (actorItr.hasNext()) {
    		Actor actr= actorItr.next(); 
    		System.out.println("actr.getIsDirector().."+actr.getIsDirector());
    		if(actr.getIsDirector()) {
    			directorList.add(actr);
				actorItr.remove();
			}
    		
    	}
 System.out.println(actorList);
 System.out.println(directorList);
        model.addAttribute("actors",actorList);
        model.addAttribute("directors",directorList);
        return "actor-list";
    }

    @GetMapping("/addNewActor")
    public String addNewActor(Model model){
        Actor actor = new Actor();
        model.addAttribute("actor",actor);
        return "new_actor";
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable(value = "id") int id){
        actorService.deleteActor(id);
        return "redirect:/showActors";
    }

    @GetMapping("/updateActor/{id}")
    public String updateActor(@PathVariable(value = "id") int id, Model model){
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor",actor);
        return "update_actor";
    }

    @PostMapping("/saveActor")
    public String saveActor(@ModelAttribute("actor") Actor actor) {
        actorService.saveActor(actor);
        return "redirect:/showActors";
    }
}
