package com.capg.bsma.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.service.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {
	@Mock
	private IBookRepository bookrepo;

	@InjectMocks /*
					 * injecting book repository marked as @Mock into book service implementation
					 */
	private BookServiceImpl bsImpl;

	@Test
	@DisplayName("BookServiceImpl::listAllBooks should return list of existing books as BookModel List")

	void testListAllBooks() throws BMSException {
		BigDecimal b = new BigDecimal("520");
		BigDecimal b1 = new BigDecimal("760");
		List<BookEntity> testdata = Arrays.asList(new BookEntity[] {

				new BookEntity(202L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
						"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(), new CategoryEntity()),
				new BookEntity(203L, "Harry Potter", "J.K.Rowling", "the lives of Harry Potter and his friends",
						"2314532798722", b1, LocalDate.now().minusDays(1), LocalDate.now(), new CategoryEntity()) });
		/* when repo.findAll( is called, then test data */

		Mockito.when(bookrepo.findAll()).thenReturn(testdata);

		List<BookModel> expected = Arrays.asList(new BookModel[] {
				new BookModel(202L, 10L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
						"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now()),
				new BookModel(203L, 11L, "Harry Potter", "J.K.Rowling", "the lives of Harry Potter and his friends",
						"2314532798722", b1, LocalDate.now().minusDays(1), LocalDate.now()) });
		List<BookModel> actual = bsImpl.listAllBooks();
		assertEquals(expected, actual);

	}

	@Test
	@DisplayName("BookServiceImpl::createBook should create books in database")
	public void testCreateBook() throws BMSException {
		BigDecimal b = new BigDecimal("544");
		BigDecimal c = new BigDecimal("2720");

		BookEntity testdata = new BookEntity(204L, "The fault in our stars", "John Green",
				"love story of cancer suffering patients", "7879654312345", b, LocalDate.now().minusDays(1),
				LocalDate.now(), new CategoryEntity(104L, "Autobiography"));

		BookModel expected = new BookModel(204L, 10L, "The fault in our stars", "John Green",
				"love story of cancer suffering patients", "7879654312345", b, LocalDate.now().minusDays(1),
				LocalDate.now());

		Mockito.when(bookrepo.save(testdata)).thenReturn(testdata);
		BookModel actual = bsImpl.createBook(expected);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("BookServiceImpl::editBook should edit books details in database")

	public void testEditBook() throws BMSException {
		BigDecimal b = new BigDecimal("800");
		BigDecimal c = new BigDecimal("4000");

		BookEntity testdata = new BookEntity(203L, "Harry Potter", "J.K.Rowling",
				"the lives of Harry Potter and his friends", "2314532798722", b, LocalDate.now().minusDays(1),
				LocalDate.now(), new CategoryEntity(104L, "Autobiography"));
		BookModel expected = new BookModel(203L, 11L, "Harry Potter", "J.K.Rowling",
				"the lives of Harry Potter and his friends", "2314532798722", b, LocalDate.now().minusDays(1),
				LocalDate.now());

		Mockito.when(bookrepo.save(testdata)).thenReturn(testdata);
		BookModel actual = bsImpl.editBook(expected);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("BookServiceImpl::deleteBook should return list of existing books ")
	public void testDeleteBook() throws BMSException {
		BigDecimal b = new BigDecimal("544");
		BigDecimal c = new BigDecimal("2720");

		BookEntity testdata = new BookEntity(204L, "The fault in our stars", "John Green",
				"love story of cancer suffering patients", "7879654312345", b, LocalDate.now().minusDays(1),
				LocalDate.now(), new CategoryEntity());
		BookModel removedata = new BookModel(204L, 10L, "The fault in our stars", "John Green",
				"love story of cancer suffering patients", "7879654312345", b, LocalDate.now().minusDays(1),
				LocalDate.now());

		Mockito.when(bookrepo.findById(204L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(bookrepo).deleteById(204L);
		boolean result = (bsImpl).deleteBook(204L);
		assertTrue(result);
	}

	@Test
	@DisplayName("BookServiceImpl::viewBook should return list of existing books as categorymodel ")

	void testViewBook() throws BMSException {
		BigDecimal b = new BigDecimal("520");
		BigDecimal c = new BigDecimal("2600");

		BookEntity testdata = new BookEntity(202L, "Unfinished", "Priyanka Chopra",
				"collection of her life experiences", "3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(),
				new CategoryEntity());
		BookModel expected = new BookModel(202L, 11L, "Unfinished", "Priyanka Chopra",
				"collection of her life experiences", "3456789987621", b, LocalDate.now().minusDays(1),
				LocalDate.now());

		Mockito.when(bookrepo.findById(testdata.getBookId())).thenReturn(Optional.of(testdata));
		BookModel actual = bsImpl.viewBook((expected.getBookId()));
		assertEquals(expected, actual);

	}
}