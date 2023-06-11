package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.services.CustomerService;
import guru.sfg.brewery.model.CustomerPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private static final Integer DEFAULT_PAGE_NUMBER =0;
    private static final Integer DEFAULT_PAGE_SIZE =25;

    private final CustomerService customerService;

    @GetMapping
    public CustomerPagedList getCustomers(@RequestParam(required = false) Integer pageNumber,
                                                @RequestParam(required = false) Integer pageSize ){
        if(pageNumber == null || pageNumber <0)
            pageNumber = DEFAULT_PAGE_NUMBER;
        if(pageSize == null || pageSize <0)
            pageSize = DEFAULT_PAGE_SIZE;
        return  customerService.listCustomers(PageRequest.of(pageNumber,pageSize));
    }
}
