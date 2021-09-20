package com.cursoee.crudlibros.lanzador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	MockMvc mock;

	@Test
	void contextLoads() throws Exception{
		mock.perform(get("/busquedaLibroIsbn/888")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testAltaLibro() throws Exception{
		mock.perform(delete("/eliminaLibro/9")).andDo(print());
		mock.perform(post("/addLibro")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"titulo\":\"React\",\"isbn\":9,\"tema\":\"programación\"}")
				).andDo(print());
		mock.perform(get("/busquedaLibroIsbn/9")).andDo(print());
	}

}
