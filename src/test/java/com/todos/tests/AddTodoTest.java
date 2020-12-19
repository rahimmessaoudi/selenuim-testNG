package com.todos.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.Setup;

public class AddTodoTest extends Setup {
	public AddTodoTest() throws IOException {
		super();
	}
	
	TodoPage todoPage;

	@Test
	public void iCanAddTodo() throws IOException, InterruptedException {
		todoPage = new TodoPage();
		boolean elementText = todoPage.isElementDisplayed(TodoPage.inputText);
		Assert.assertTrue(elementText);
		todoPage.submitTodo(prop.getProperty("todo1"));
		Thread.sleep(1000);
		String elementTodo = todoPage.checkElementContains(TodoPage.element1);
		Assert.assertTrue(elementTodo.contains(prop.getProperty("todo1")));
		boolean checkbox = todoPage.isCheckboxSelected(TodoPage.checkbox);
		Assert.assertFalse(checkbox);
	}
	

}
