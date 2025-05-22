package com.modelo.parcial.modelo_parcial;

import jakarta.persistence.ManyToMany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ModeloParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloParcialApplication.class, args);
	}
	/*@ManyToMany (lado peliculas)
    @JoinTable(
            name = "pelicula_actor",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actores = new HashSet<>();*/

	/*@ManyToMany(mappedBy = "actores") (lado actores)
	private Set<Pelicula> peliculas = new HashSet<>();*/
}
