/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.helmut.test.tomee;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author HelmutS
 */
@Stateless
public class MiniBean {

	public String sayHello() {
		return "Hello TomEE. The current date: " + new Date();
	}
}
