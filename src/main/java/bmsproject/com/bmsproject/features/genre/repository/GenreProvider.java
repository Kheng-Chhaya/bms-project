package bmsproject.com.bmsproject.features.genre.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import bmsproject.com.bmsproject.features.genre.model.GenreModel;

public class GenreProvider {
    public String  insertProvider(@Param("genre") GenreModel genre)
    {
        return new SQL(){{
            // your SQL
            if(!(genre.getTitle().isBlank() && genre.getDescription().isBlank()))
            {
                INSERT_INTO("genres");
                VALUES("title", "#{genre.title}");
                VALUES("description","#{genre.description}");
                VALUES("icon", "#{genre.icon}");
                VALUES("is_enabled", "#{genre.isEnabled}");
            }
           

        }}.toString();
    }

    public String deleteProvider()
    {
        return new SQL(){{
            DELETE_FROM("genres");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String updateProvider()
    {
        return new SQL()
        {{
            UPDATE("genres");
            SET("title = #{genre.title}");
            SET("description = #{genre.description}");
            WHERE("id = #{id}");
        }}.toString();
    }
}
