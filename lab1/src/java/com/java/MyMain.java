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
import javax.xml.ws.*;
public class MyMain
{
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:4848/hello",new HelloWs());
	}
}
