package com.excelr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.excelr.model.Player;

@Controller
public class HelloController {

    @RequestMapping("/appstore")
    public String hello() {
        return "apple"; // <-- This must match apple.jsp (no extension)
    }
    
    @RequestMapping("/studName")
    public String displayStudentName(Model model) {
    	
    	Player player = new Player();
    	player.setJno(18);
    	player.setMp(100);
    	player.setPlayerName("Virat");
    	player.setRs(5000);
    	model.addAttribute("myplayer",player); 
    	
    	
        return "ipl"; // <-- This must match apple.jsp (no extension)
    }
    
    @RequestMapping("/player")
    public String displayStudentName(ModelMap modelmap) {
    	
    	Player player = new Player();
    	player.setJno(45);
    	player.setMp(150);
    	player.setPlayerName("Rohit");
    	player.setRs(10000);
    	

    	Player player1 = new Player();
    	player1.setJno(15);
    	player1.setMp(170);
    	player1.setPlayerName("ABD");
    	player1.setRs(12300);
    	modelmap.addAttribute("myplayer2",player); 
    	modelmap.addAttribute("batsmen",player1); 
    	
        return "mumbai"; // <-- This must match apple.jsp (no extension)
    }
    
    @RequestMapping("/newplayer")
    public ModelAndView displayPlayer1() {
    	
    	Player player = new Player();
    	player.setJno(88);
    	player.setMp(10);
    	player.setPlayerName("Shubman");
    	player.setRs(500);
    	
    	ModelAndView mav= new ModelAndView();
    	mav.setViewName("gujarat-titans");
    	mav.addObject("skipper",player);
    	
    	
        return mav; // <-- This must match apple.jsp (no extension)
    }
    
    
    @RequestMapping("/players")
    public String displayAllPlayers(Model model) {

        Player player1 = new Player();
        player1.setJno(18);
        player1.setMp(100);
        player1.setPlayerName("Virat");
        player1.setRs(5000);

        Player player2 = new Player();
        player2.setJno(88);
        player2.setMp(10);
        player2.setPlayerName("Shubman");
        player2.setRs(500);

        Player player3 = new Player();
        player3.setJno(15);
        player3.setMp(170);
        player3.setPlayerName("ABD");
        player3.setRs(12300);

        Player player4 = new Player();
        player4.setJno(45);
        player4.setMp(150);
        player4.setPlayerName("Rohit");
        player4.setRs(10000);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        // Correct attribute name must match what JSP is expecting
        model.addAttribute("allplayers", players); 

        return "ict"; // jsp: ict.jsp
    }

    @RequestMapping("/addPlayerForm")
    public String addPlayerForm(Model model)
    {
        Player player = new Player();
        model.addAttribute("player",player);
        return "add-player-form";
 
    }
    
    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player filledplayer, Model model)
    {
        System.out.println("Player record added "+ filledplayer.getPlayerName());
        model.addAttribute("player", filledplayer);
        return "confirm";

    }
}




//localhost:8080/appstore