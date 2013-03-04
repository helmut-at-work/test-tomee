test-tomee-remote
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

Output:<br />
...<br />
org.apache.tomee.arquillian.remote.RemoteTomEEContainer start<br />
INFO: TomEE found running on port 8080<br />
...<br />
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 3.285 sec <<< FAILURE!<br />
testSayHello(de.helmut.test.tomee.MiniBeanTest)  Time elapsed: 0.193 sec  <<< FAILURE!<br />
java.lang.AssertionError<br />
	at org.junit.Assert.fail(Assert.java:86)<br />
	at org.junit.Assert.assertTrue(Assert.java:41)<br />
	at org.junit.Assert.assertNotNull(Assert.java:621)<br />
	at org.junit.Assert.assertNotNull(Assert.java:631)<br />
	at de.helmut.test.tomee.MiniBeanTest.testSayHello(MiniBeanTest.java:36)<br />
...<br />
