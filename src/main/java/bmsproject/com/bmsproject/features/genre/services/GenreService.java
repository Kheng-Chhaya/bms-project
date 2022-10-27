package bmsproject.com.bmsproject.features.genre.services;

import java.util.List;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;

public interface GenreService {
    
    List<GenreModel> findAll();

    GenreModel findById(Integer id);

    GenreModel deleteById(Integer id);

    GenreModel addNew(GenreModel genre);
    
    GenreModel updateById(Integer id,GenreModel genre);
    
}
