package vn.techmaster.money.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.money.model.CurrencyRate;
import vn.techmaster.money.request.MoneyConvertRequest;
import vn.techmaster.money.service.MoneyConverter;


@Controller
@RequestMapping("/money")
public class MoneyController {

  @Autowired
  private MoneyConverter moneyConverter;

  @GetMapping()
  public String renderForm(Model model) {
    model.addAttribute("moneyConvertRequest", new MoneyConvertRequest());

    List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();
    
    model.addAttribute("currencies", currencies);  
    return "form";
  }

  @PostMapping()
  public String convertMoney(@ModelAttribute("moneyConvertRequest") MoneyConvertRequest request, BindingResult bindingResult, Model model){
    List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();
    model.addAttribute("currencies", currencies);
    if(!bindingResult.hasErrors()){
      float fromExchangeRate = moneyConverter.getExchangeRate(request.getFromCurrency());
      float toExchangeRate = moneyConverter.getExchangeRate(request.getToCurrency());
      float exRateBetweenFromAndTo = fromExchangeRate / toExchangeRate;
      float exRateBetweenToAndFrom = toExchangeRate / fromExchangeRate;
      DecimalFormat decimalFormat = new DecimalFormat("###,###.########");
      model.addAttribute("exRateBetweenFromAndTo", decimalFormat.format(exRateBetweenFromAndTo));
      model.addAttribute("exRateBetweenToAndFrom", decimalFormat.format(exRateBetweenToAndFrom));
      float result = request.getAmount() * exRateBetweenToAndFrom;
      model.addAttribute("result", decimalFormat.format(result));
    } else {
      model.addAttribute("message", "Số quá lớn! không thể tính toán!!!");
    }
    return "form";
  }

}
