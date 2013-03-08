test-tomee
Example for arquillian remote container don't work with CDI in tests.
==========
This is my example project to try using a tomee arquillian remote configuration
as described in:
http://rmannibucau.wordpress.com/2012/06/17/arquillian-and-existing-tomee/

The example ist based on the maven archetype
groupId: org.apache.openejb.maven
artifactId: tomee-webapp-archetype

If I configure in the arquillian.xml
			<property name="httpPort">-1</property> ...
it worked. If I configure arquillian.xml like discribed in the article
			<property name="httpPort">8080</property>
I can't get the CDI injection to work
Output:
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running de.helmut.test.tomee.MiniBeanTest
Mrz 04, 2013 8:58:01 AM org.apache.tomee.arquillian.remote.RemoteTomEEContainer start
INFO: TomEE found running on port 8080
Mrz 04, 2013 8:58:02 AM org.apache.openejb.client.EventLogger log
INFO: RemoteInitialContextCreated{providerUri=http://localhost:8080/tomee/ejb}
Mrz 04, 2013 8:58:03 AM org.apache.openejb.client.EventLogger log
INFO: RemoteInitialContextCreated{providerUri=http://localhost:8080/tomee/ejb}
...
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 3.285 sec <<< FAILURE!
testSayHello(de.helmut.test.tomee.MiniBeanTest)  Time elapsed: 0.193 sec  <<< FAILURE!
java.lang.AssertionError
	at org.junit.Assert.fail(Assert.java:86)
	at org.junit.Assert.assertTrue(Assert.java:41)
	at org.junit.Assert.assertNotNull(Assert.java:621)
	at org.junit.Assert.assertNotNull(Assert.java:631)
	at de.helmut.test.tomee.MiniBeanTest.testSayHello(MiniBeanTest.java:36)
...


===========================================================
Solution
===========================================================
This seems to be a bug fixed in the 1.6.0-SNAPSHOT of TomEE
