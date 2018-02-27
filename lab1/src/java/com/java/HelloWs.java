/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

/**
 *
 * @author Mahmoud
 */
import javax.jws.WebService;
@WebService
public class HelloWs{
	private String message="Hello";
	public String sayHello(String name)
	{
		return message+name;
	}
}
