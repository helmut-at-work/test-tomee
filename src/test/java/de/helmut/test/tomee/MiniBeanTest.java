/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.helmut.test.tomee;

import javax.ejb.EJB;
import javax.naming.InitialContext;
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

//		File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().as(File.class);
//		WebArchive war2 = ShrinkWrap
//				.create(WebArchive.class, "test.war")
//				.addPackage(MiniBean.class.getPackage())
//				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
//				.addAsLibraries(libs);

		return war;
	}

	@Test
	public void testSayHello() throws Exception {
		System.out.println("sayHello");
		if (mini == null) {
			System.out.println("CDI dosen't work!");
			//mini = InitialContext.doLookup("java:global/MiniBeanIT/MiniBean");
		}
		assertNotNull(mini);
		String hello = mini.sayHello();
		System.out.println(hello);
		assertTrue(hello.startsWith("Hello TomEE. The current date: "));
	}
}
