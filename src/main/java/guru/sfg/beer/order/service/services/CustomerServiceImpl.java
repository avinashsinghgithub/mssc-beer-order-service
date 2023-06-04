package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.repositories.CustomerRepository;
import guru.sfg.beer.order.service.web.mappers.CustomerMapper;
import guru.sfg.brewery.model.CustomerDto;
import guru.sfg.brewery.model.CustomerPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements  CustomerService{
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
    @Override
    public CustomerPagedList listCustomers(Pageable pageable) {

        Page<Customer> pagedContent = customerRepository.findAll(pageable);
        //mapper.
        List<CustomerDto> list =  pagedContent
                .getContent()
                .stream()
                .map(customer -> customerMapper.customerToDto(customer))
                .collect(Collectors.toList());
        CustomerPagedList customerPagedList
                = new CustomerPagedList(list,
                    PageRequest.of(pagedContent.getNumber(),pagedContent.getSize()),
                    pagedContent.getTotalElements());

        return customerPagedList;
    }
}
