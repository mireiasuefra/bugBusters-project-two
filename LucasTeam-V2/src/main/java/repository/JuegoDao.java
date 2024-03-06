package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Juego;

@Repository
public interface JuegoDao extends JpaRepository<Juego ,Integer> {
	
	
}
