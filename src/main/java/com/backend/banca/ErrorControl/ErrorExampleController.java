package com.backend.banca.ErrorControl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("API/v1/showerror")
public class ErrorExampleController {

  @GetMapping("divisionZero")
  public String errorLaunch() {
    int c = 4 / 0;

    return "Test" + c;
  }

  @GetMapping("error500")
  public String error500() {
    throw new RuntimeException("Error inesperado---");
  }


}