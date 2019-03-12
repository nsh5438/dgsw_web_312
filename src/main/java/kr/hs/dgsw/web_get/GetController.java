package kr.hs.dgsw.web_get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

    @GetMapping("/Greating")
    public String greating(
            @RequestParam String say,
            @RequestParam(required = false, defaultValue = "NAME") String to){
        return say + " " + to;
    }

    @GetMapping(
        value = {
                "/greeting1/{say}/{to}",
                "/greeting1",
                "/greeting1//{to}",
                "/greeting1/{say}"
        })
    public String greeting1(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ){
        String tmp = to.isPresent() ? to.get (): "NONAME";
        String tm2 = say.isPresent() ? say.get() : "메롱";
        return tm2 + " " + tmp;
    }
}
