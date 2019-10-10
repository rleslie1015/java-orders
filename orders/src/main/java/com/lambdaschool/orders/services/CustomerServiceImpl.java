package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll()
	{
		List<Customer> rtnList = new ArrayList<>();
		customerRepository.findAll().iterator().forEachRemaining(rtnList :: add);
		return rtnList;

	}

	@Override
	public Customer findById(long id)
	{
		return null;
	}

	@Override
	public Customer save(Customer customer)
	{
		Customer newCustomer = new Customer();

		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgent(customer.getAgent());

		for(Order o : customer.getOrders())
		{
			newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamt(), o.getCustomer(), o.getOrddescription()));
		}

		return customerRepository.save(newCustomer);
	}

	@Override
	public Customer update(Customer customer, long id)
	{
		return customerRepository.save(customer);

	}

	@Override
	public void delete(long id)
	{
		customerRepository.deleteById(id);
	}
}
