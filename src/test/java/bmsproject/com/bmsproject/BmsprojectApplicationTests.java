package bmsproject.com.bmsproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;
import bmsproject.com.bmsproject.features.genre.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BmsprojectApplicationTests {
	@Autowired
	GenreRepository genreRepository;
	@Test
	void selectData() {
		List<GenreModel> genreModels = genreRepository.selects();
		log.info("Genre = {}",genreModels);
		GenreModel genreID = genreRepository.selectID(1);
		log.info("GenreID is {}", genreID);
	}

}
