package org.launchcode.coding_events_practice.controllers;

import jakarta.validation.Valid;
import org.launchcode.coding_events_practice.data.EventData;
import org.launchcode.coding_events_practice.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "Coding Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

//    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
//        EventData.add(new Event(eventName, eventDescription));
//        return "redirect:/events";
//    }
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid  Event newEvent, Errors errors, Model model) {

    if(errors.hasErrors()) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }
    EventData.add(newEvent);
    return "redirect:/events";
}

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";
    }
}
