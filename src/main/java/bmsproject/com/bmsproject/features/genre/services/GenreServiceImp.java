package bmsproject.com.bmsproject.features.genre.services;

import java.util.List;

import org.springframework.stereotype.Service;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;
import bmsproject.com.bmsproject.features.genre.repository.GenreRepository;
@Service
public class GenreServiceImp implements GenreService
{
    private final GenreRepository genreRepository;
    
    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreModel> findAll() {
        // logic here
        return genreRepository.selects();
        
    }

    @Override
    public GenreModel findById(Integer id) {
        
        return genreRepository.selectID(id);
    }

    @Override
    public GenreModel deleteById(Integer id) {
        
        GenreModel genre = genreRepository.selectID(id);
        genreRepository.delete(id);
        return genre;
    }

    @Override
    public GenreModel addNew(GenreModel genre) {
        
        genre.setIcon(1);
        genre.setIsEnabled(true);
        genreRepository.insert(genre);
        return genreRepository.selectID(genre.getId());
    }

    @Override
    public GenreModel updateById(Integer id, GenreModel genre) {
        genreRepository.update(id, genre);
        return findById(id);
    }
    
}
