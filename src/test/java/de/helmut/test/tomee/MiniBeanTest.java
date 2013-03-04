/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.helmut.test.tomee;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import static org.junit.Assert.*;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(Arquillian.class)
public class MiniBeanTest {

	@EJB
	MiniBean mini;

	@Deployment
	public static Archive<?> createDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class, "MiniBeanIT.war")
				.addPackage(MiniBean.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
		return war;
	}

	@Test
	public void testSayHello() throws Exception {
		System.out.println("sayHello");
		assertNotNull(mini);
		String hello = mini.sayHello();
		System.out.println(hello);
		assertTrue(hello.startsWith("Hello TomEE. The current date: "));
	}
}
