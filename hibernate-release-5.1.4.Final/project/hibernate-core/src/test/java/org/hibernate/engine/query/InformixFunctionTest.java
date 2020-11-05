package org.hibernate.engine.query;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.dialect.InformixDialect;

import org.hibernate.testing.RequiresDialect;
import org.hibernate.testing.TestForIssue;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Vlad Mihalcea
 */
@RequiresDialect(InformixDialect.class)
public class InformixFunctionTest extends BaseCoreFunctionalTestCase {

	private Event event;

	@Override
	protected void prepareTest() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		event = new Event();
		event.country = "Romania";
		event.city = "Cluj-Napoca";
		session.persist( event );
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10846" )
	public void testConcat() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		String location = (String) session.createQuery(
				"select concat(e.country, ' - ',  e.city) " +
						"from Event e " +
						"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();
		assertEquals( "Romania - Cluj-Napoca", location );
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10846" )
	public void testSubstring() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		String location = (String) session.createQuery(
				"select substring(e.city, 0, 5) " +
						"from Event e " +
						"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();
		assertEquals( "Cluj", location);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10846" )
	public void testSubstr() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		String location = (String) session.createQuery(
				"select substr(e.city, 0, 4) " +
						"from Event e " +
						"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();
		assertEquals( "Cluj", location);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10846" )
	public void testCoalesceAndNvl() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		String location = (String) session.createQuery(
				"select coalesce(e.district, 'N/A') " +
						"from Event e " +
						"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();
		assertEquals( "N/A", location);

		location = (String) session.createQuery(
				"select nvl(e.district, 'N/A') " +
						"from Event e " +
						"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();
		assertEquals( "N/A", location);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10800" )
	public void testCurrentDate() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		Date date = (Date) session.createQuery(
				"select current_date() " +
						"from Event e " +
					"where e.id = :id")
				.setParameter( "id", event.id )
				.uniqueResult();

		assertNotNull( date );
		assertTrue( date.getTime() > 0 );

		Calendar resultCalendar = Calendar.getInstance();
		resultCalendar.setTime(date);

		assertEquals( 0, todayCalendar().compareTo(resultCalendar) );
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@TestForIssue( jiraKey = "HHH-10800" )
	public void testCurrentTimestamp() throws Exception {
		Session session = openSession();
		session.getTransaction().begin();
		int tries = 2;
		while ( tries-- > 0 ) {
			Timestamp timestamp = (Timestamp) session.createQuery(
					"select current_timestamp() " +
							"from Event e " +
							"where e.id = :id" )
					.setParameter( "id", event.id )
					.uniqueResult();

			assertNotNull( timestamp );
			assertTrue( timestamp != null && timestamp.getTime() > 0 );

			Calendar resultCalendar = Calendar.getInstance();
			resultCalendar.setTime( timestamp );

			long millis = resultCalendar.getTime().getTime() - todayCalendar().getTime().getTime();

			if(millis == 0) {
				//What are the odds that ou've run this test exactly at midnight?
				try {
					Thread.sleep( 1000 );
				}
				catch ( InterruptedException ignore ) {}
				continue;
			}

			assertTrue( millis > 0 );
		}
		session.getTransaction().commit();
		session.close();
	}

	private Calendar todayCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class<?>[] {
				Event.class
		};
	}

	@Entity(name = "Event")
	public static class Event {

		@Id
		@GeneratedValue
		private Long id;

		@Column
		private String country;

		private String city;

		private String district;
	}
}


