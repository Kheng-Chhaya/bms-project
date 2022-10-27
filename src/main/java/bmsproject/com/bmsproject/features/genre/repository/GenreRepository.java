package bmsproject.com.bmsproject.features.genre.repository;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;

@Repository
public interface GenreRepository {
    
    // @Insert("INSERT INTO genres (title,description,icon,is_enabled) VALUES (#{genre.title},#{genre.description},#{genre.icon},#{genre.isEnabled})")
   @InsertProvider(type = GenreProvider.class,method = "insertProvider")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insert(@Param("genre") GenreModel genre);

    // @Update("UPDATE genres SET title= #{genre.title},description=#{genre.description} WHERE id = #{id}")
    @UpdateProvider(type = GenreProvider.class,method = "updateProvider")
    void update(@Param("id") Integer id,@Param("genre") GenreModel genre);

    // @Delete("DELETE FROM genres WHERE id = #{id}")
    @DeleteProvider(type = GenreProvider.class,method = "deleteProvider")
    void delete(@Param("id") Integer id);
    // Inline SQL
    @Select("SELECT * FROM genres ORDER BY id DESC")
    @Results(id = "resultMap",value = 
    {
        @Result(column = "is_enabled",property = "isEnabled")
    })
    List<GenreModel> selects();

    @Select("SELECT * FROM genres WHERE id = #{id}")
    @ResultMap(value="resultMap")
    GenreModel selectID(@Param("id")Integer id);
}
