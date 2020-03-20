package com.xzj;

import com.xzj.bean.Film;
import com.xzj.bean.Language;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.xzj.bean")
public class FilmConfig {

    /*@Bean
    public Language createLanguage(){
        return new Language();
    }*/

    @Bean(name = "film1")
    public Film createFilm(Language language){
        Film myfilm = new Film();
        myfilm.setLanguage(language);
        return myfilm;
    }

    @Bean(name = "film2")
    public Film myFilm(Language language){
        Film myFilm = new Film();
        myFilm.setLanguage(language);
        return myFilm;
    }


}
