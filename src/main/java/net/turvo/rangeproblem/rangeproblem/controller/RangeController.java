package net.turvo.rangeproblem.rangeproblem.controller;

import lombok.RequiredArgsConstructor;
import net.turvo.rangeproblem.rangeproblem.service.RangeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ranges")
@RequiredArgsConstructor
public class RangeController {

    private final RangeServiceImpl rangeService;

    @GetMapping
    public Set<String> getNodes(@RequestParam String city, @RequestParam Integer time) {
        return rangeService.findCities(city, time);
    }


}
