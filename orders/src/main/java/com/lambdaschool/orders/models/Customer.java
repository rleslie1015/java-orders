package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cutomers")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long CustCode;

	@Column(nullable = false)
	private String custname;

	private String city;
	private String workingarea;
	private String grade;
	private double openingamt;
	private double receiveamt;
	private double outstandingamt;
	private String phone;

	@ManyToOne
	@JoinColumn(name = "agentcode",
			nullable = false)
	@JsonIgnoreProperties("customers")
	private Agent agent;

	//one to many relationship
	//one to many Menus
	//mapped to a field
	// cascade - if we delete a restaurant all the menus will be deleted
	//orphan removal - if we find a menu that is not tied to a restaurant it will get deleted
	@OneToMany(mappedBy = "customers",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnoreProperties("customers")
	private List<Order> orders = new ArrayList<>();

	public Customer()
	{
	}

	public Customer(String custname, String city, String workingarea, String grade, double openingamt, double receiveamt, double outstandingamt, String phone, Agent agent)
	{
		this.custname = custname;
		this.city = city;
		this.workingarea = workingarea;
		this.grade = grade;
		this.openingamt = openingamt;
		this.receiveamt = receiveamt;
		this.outstandingamt = outstandingamt;
		this.phone = phone;
		this.agent = agent;
	}

	public long getCustCode()
	{
		return CustCode;
	}

	public void setCustCode(long custCode)
	{
		CustCode = custCode;
	}

	public String getCustname()
	{
		return custname;
	}

	public void setCustname(String custname)
	{
		this.custname = custname;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getWorkingarea()
	{
		return workingarea;
	}

	public void setWorkingarea(String workingarea)
	{
		this.workingarea = workingarea;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public double getOpeningamt()
	{
		return openingamt;
	}

	public void setOpeningamt(double openingamt)
	{
		this.openingamt = openingamt;
	}

	public double getReceiveamt()
	{
		return receiveamt;
	}

	public void setReceiveamt(double receiveamt)
	{
		this.receiveamt = receiveamt;
	}

	public double getOutstandingamt()
	{
		return outstandingamt;
	}

	public void setOutstandingamt(double outstandingamt)
	{
		this.outstandingamt = outstandingamt;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Agent getAgent()
	{
		return agent;
	}

	public void setAgent(Agent agent)
	{
		this.agent = agent;
	}

	public List<Order> getOrders()
	{
		return orders;
	}

	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}
}
