package me.motemere.laforeapi.controller;

import me.motemere.code.array.OrdArray;
import me.motemere.laforeapi.helper.OrdArrayHelper;
import me.motemere.laforeapi.helper.PlugHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array")
public class ArrayController {

  @PostMapping("/sort")
  public String array(@RequestBody String request) {
    OrdArray ordArray = OrdArrayHelper.getOrdArray(request);

    return OrdArrayHelper.getJson(ordArray);
  }

  @GetMapping("/plug")
  public String plug() {
    return PlugHelper.getPlay();
  }

}
