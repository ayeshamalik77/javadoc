

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *LibraryTest class
*<p>test LMS
*Software Development 1</p>
*@author Ayesha Malik
*@since 2/24/24
*/

class LibraryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Test whether delete books works
	 */
	final void testDeleteBooks() {
		int result = Library.deleteBooks();
		if(result > 0 ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
/**
 * Test whether the books were added
 */
	@Test
	final void testAddBooks() {
		int result = Library.addBooks("books.txt");
		if(result > 0 ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
/**
 * Test whether the books were deleted by barcode 
 */
	@Test
	final void testDeleteBookByBarcode() {
		int result = Library.deleteBookByBarcode("11111");
		if(result > 0 ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
/**
 * Test whether the books are checked out by title number
 */
	@Test
	final void testCheckOutBookByTitleNumber() {
		int result = Library.checkOutBookByTitleNumber("1");
		if(result > 0 ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
/**
 * Test whether book is checked in by title number
 */
	@Test
	final void testCheckInBookByTitleNumber() {
		int result = Library.checkInBookByTitleNumber("");
		if(result > 0 ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

}
